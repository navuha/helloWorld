package model;

import org.apache.log4j.Logger;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Database {
    private static final Logger LG = Logger.getLogger(Database.class);
    private static final Connection CN;
    
    
    public static void logErrAndOutOf(final String partOfAMessage, final SQLException no) {
        LG.error("The fail in the " + partOfAMessage + "! Out of the program...", no);
        System.exit(no.getErrorCode());
        
    }
    
    
    private static void mkAllTables() {
        final String createAccountsTbl = "CREATE TABLE accounts ("
                + "id INTEGER NOT NULL AUTO_INCREMENT,"
                + "balance INTEGER NOT NULL DEFAULT 0,"
                + "CONSTRAINT accounts_chck_on_blnc CHECK (balance >= 0),"
                + "PRIMARY KEY (id))";
        final String createTransactionsTbl = "CREATE TABLE transactions ("
                + "id INTEGER NOT NULL,"
                + "state INTEGER NOT NULL DEFAULT 0,"
                + "sender INTEGER NOT NULL,"
                + "receiver INTEGER NOT NULL,"
                + "amount INTEGER NOT NULL,"
                + "CONSTRAINT transactions_chck_on_amnt CHECK (amount > 0),"
                + "PRIMARY KEY (id),"
                + "CONSTRAINT transactions_fk1 FOREIGN KEY (sender) REFERENCES accounts(id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE,"
                + "CONSTRAINT transactions_fk2 FOREIGN KEY (receiver) REFERENCES accounts(id) "
                + "ON DELETE CASCADE ON UPDATE CASCADE)";
        
        try (final Statement stt = CN.createStatement()) {
            stt.executeUpdate(createAccountsTbl);
            stt.executeUpdate(createTransactionsTbl);
            
        } catch (final SQLException no) {
            logErrAndOutOf("making of some tables", no);
        }
        
    }
    
    static {
        Connection atDB;
        try {
            final JdbcDataSource src = new JdbcDataSource();
            src.setURL("jdbc:h2:mem:Transfer");
            src.setUser("user");
            src.setPassword("");
            
            atDB = src.getConnection();
            
        } catch (final SQLException no) {
            atDB = null;
            logErrAndOutOf("making of a connection", no);
            
        }
        
        CN = atDB;
        
        mkAllTables();
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeAllOnDB()));
        
    }
    
    
    private static final PreparedStatement
            UPDATE_IN_STATE, INSERT_ACCOUNT, INSERT_TRANSACTION;
    
    static {
        PreparedStatement updateInState, insertAccount, insertTransaction;
        try {
            updateInState = CN.prepareStatement("UPDATE transactions SET state = ? WHERE id = ?");
            insertAccount = CN.prepareStatement("INSERT INTO accounts VALUES (?, ?)");
            insertTransaction = CN.prepareStatement("INSERT INTO transactions VALUES (?, ?, ?, ?, ?)");
            
        } catch (final SQLException no) {
            updateInState = insertAccount = insertTransaction = null;
            logErrAndOutOf("making of some prepared statements in " + Database.class.getName(), no);
            
        }
        
        UPDATE_IN_STATE = updateInState;
        INSERT_ACCOUNT = insertAccount;
        INSERT_TRANSACTION = insertTransaction;
        
    }
    
    
    public static void setToAManCommit() throws SQLException {
        CN.setAutoCommit(false);
    }
    
    public static void commitTrans(int transactionId) throws SQLException {
        CN.commit();
        
        UPDATE_IN_STATE.setInt(1, TransactionState.COMMITED.getValue());
        UPDATE_IN_STATE.setInt(2, transactionId);
        UPDATE_IN_STATE.executeUpdate();
        
    }
    
    
    public static PreparedStatement mkPS(final String query) throws SQLException {
        return CN.prepareStatement(query);
    }
    
    
    public static void insertIntoAccounts(final int userId, final int balance) throws SQLException {
        INSERT_ACCOUNT.setInt(1, userId);
        INSERT_ACCOUNT.setInt(2, balance);
        INSERT_ACCOUNT.executeUpdate();
        
        CN.commit();
        
    }
    
    public static void insertIntoTransactions(final int transactionId, final int off,
            final int to, final int amount) throws SQLException {
        INSERT_TRANSACTION.setInt(1, transactionId);
        INSERT_TRANSACTION.setInt(2, TransactionState.STARTED.getValue());
        INSERT_TRANSACTION.setInt(3, off);
        INSERT_TRANSACTION.setInt(4, to);
        INSERT_TRANSACTION.setInt(5, amount);
        INSERT_TRANSACTION.executeUpdate();
        
        CN.commit();
        
    }
    
    
    private static void closeAllOnDB() {
        try (final Connection atDB = CN; final PreparedStatement updateInAState = UPDATE_IN_STATE;
                final PreparedStatement insertAccount = INSERT_ACCOUNT;
                final PreparedStatement insertTransaction = INSERT_TRANSACTION) {}
        catch (final SQLException no) {
            logErrAndOutOf("closing of some DB resources", no);
        }
        
    }
    
}
