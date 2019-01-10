import service.CommitService;
import service.TransactService;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;

import java.sql.SQLException;

public class TransferVerticle extends AbstractVerticle {
    private static final Logger LG = Logger.getLogger(TransferVerticle.class);
    private static final int PORT = 9080;
    
    
    @Override
    public void start(final Future<Void> futurePrm) {
        final TransactService transact = new TransactService();
        final CommitService commit = new CommitService();
        
        final Router rtMkr = Router.router(vertx);
        
        rtMkr.post("/transaction").handler(routingContext -> {
            final CompletableFuture<String> futureTransactionId = new CompletableFuture<>();
            routingContext.request().bodyHandler(body -> {
                try {
                    final String future = String.format("Transaction %d",
                            transact.transact(body.toString()));
                    futureTransactionId.complete(future);
                    
                } catch (final SQLException no) {
                    LG.error("I can not make a transaction!", no);
                    futureTransactionId.complete(no.getMessage());
                    
                }
                
            });
            
            futureTransactionId.thenAccept(completedFuture -> routingContext.response()
                    .putHeader("content-length", String.valueOf(completedFuture.length()))
                    .end(String.valueOf(completedFuture))
            );
            
        });

        rtMkr.put("/transaction/:id").handler(routingContext -> {
            final CompletableFuture<String> futureOffTransaction = new CompletableFuture<>();
            
            try {
                final int transactionId = Integer.parseInt(routingContext.request().getParam("id"));
                futureOffTransaction.complete(commit.commitTransaction(transactionId));
                
            } catch (final SQLException | NumberFormatException no) {
                LG.error("I can not commit the transaction!", no);
                routingContext.response().setStatusCode(500);
                futureOffTransaction.complete(no.getMessage());
                
            }
            
            futureOffTransaction.thenAccept(completedFuture -> routingContext.response().end(completedFuture));
            
        });
        
        vertx.createHttpServer().requestHandler(rtMkr).listen(PORT,
                result -> {
                    if (result.succeeded()) futurePrm.complete();
                    else futurePrm.fail(result.cause());
                    
                });
        
    }
    
}
