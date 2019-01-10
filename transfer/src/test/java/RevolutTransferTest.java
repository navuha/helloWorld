import model.Account;
import model.Database;
import model.SerializableTransaction;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.json.Json;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;

import java.sql.SQLException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

public class RevolutTransferTest {
    private final static Vertx VERTX = Vertx.vertx();
    private final static Logger LG = Logger.getLogger(RevolutTransferTest.class);
    private final static HttpClient CLIENT = VERTX.createHttpClient();
    private final static int PORT = 9080;
    
    private static void populateAccountsTbl() throws IOException {
        Files.lines(Paths.get("accounts.txt"), Charset.forName("UTF-8"))
                .map(line -> line.split(" ")).forEach(accountRow -> {
            LG.debug(String.format("Just before insertion of an account row \"%s, %s\".",
                    accountRow[0], accountRow[1]));
            try {
                Database.insertIntoAccounts(Integer.parseInt(accountRow[0]), Integer.parseInt(accountRow[1]));
            } catch (final SQLException no) {
                LG.error("The fail in a population of the database!", no);
            }
            
        });
        
    }
    
    static {
        try {
            BasicConfigurator.configure();
            
            VERTX.deployVerticle(TransferVerticle.class.getName());
            
            populateAccountsTbl();
            
        } catch (final IOException no) {
            LG.error("The fail in an initializing the test class!", no);
        }
        
    }
    
    
    private void completeRestCalls(final Account sender, final Account receiver, final int amount)
            throws SQLException, ExecutionException, InterruptedException {
        final String json = Json.encodePrettily(
                new SerializableTransaction(sender.getId(), receiver.getId(), amount));
        
        final String length = Integer.toString(json.length());
        
        final CompletableFuture<String> transactionId = new CompletableFuture<>(),
                transactionResult = new CompletableFuture<>();
        
        CLIENT.post(PORT, "localhost", "/transaction")
                .putHeader("content-type", "application/json")
                .putHeader("content-length", length)
                .handler(response -> response.bodyHandler(body ->
                        transactionId.complete(body.toString())))
                .end(json);
        
        transactionId.thenAccept(transactionMsg -> {
            final Matcher matcher = Pattern.compile("Transaction (0|[1-9][0-9]*)")
                    .matcher(transactionMsg);
            
            if (matcher.find()) {
                final int id = Integer.parseInt(matcher.group(1));
                
                LG.debug(transactionMsg);
                
                CLIENT.put(PORT, "localhost", String.format("/transaction/%d", id))
                        .handler(response -> response.bodyHandler(body ->
                                transactionResult.complete(body.toString())))
                        .end();
                
            } else transactionResult.complete("Invalid Transaction!");
            
        });
        
        LG.debug(transactionResult.get());
        
    }
    
    
    @AfterClass
    public static void tearDown() throws SQLException {
        try {
            final Field f = Database.class.getDeclaredField("CN");
            f.setAccessible(true);
            
            ((Connection) f.get(null)).close();
            
        } catch (final NoSuchFieldException | IllegalAccessException no) {
            LG.debug("I can not access the field!", no);
        }
        
    }
    
    
    @Test
    public void testSimpleTransfer() throws Exception {
        LG.debug("Starting the testSimpleTransfer test...");
        
        final Account sender = new Account(1),
                receiver = new Account(2);
        final int transactionAmount = 10,
                senderBalance = sender.getBalance(),
                receiverBalance = receiver.getBalance();
        
        completeRestCalls(sender, receiver, transactionAmount);
        assert(sender.getBalance() == senderBalance - transactionAmount);
        assert(receiver.getBalance() == receiverBalance + transactionAmount);
        
    }
    
    @Test
    public void transferInvalidAmount() throws Exception {
        LG.debug("Starting the transferInvalidAmount test...");
        
        final Account sender = new Account(4),
                receiver = new Account(5);
        final int transactionAmount = -2,
                senderBalance = sender.getBalance(),
                receiverBalance = receiver.getBalance();

        completeRestCalls(sender, receiver, transactionAmount);
        assert(sender.getBalance() == senderBalance);
        assert(receiver.getBalance() == receiverBalance);
        
    }
    
    @Test
    public void transferNoFunds() throws Exception {
        LG.debug("Starting the transferNoFunds test...");
        
        final Account sender = new Account(7),
                receiver = new Account(8);
        final int transactionAmount = 20,
                senderBalance = sender.getBalance(),
                receiverBalance = receiver.getBalance();
        
        completeRestCalls(sender, receiver, transactionAmount);
        assert(sender.getBalance() == senderBalance);
        assert(receiver.getBalance() == receiverBalance);
        
    }
    
}
