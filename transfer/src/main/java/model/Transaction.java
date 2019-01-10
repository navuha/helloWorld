package model;

import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import exception.TransactionNonFound;

public class Transaction {
    private static final Logger LG = Logger.getLogger(Transaction.class);
    private static final AtomicInteger COUNTER = new AtomicInteger();
    
    private final int ID;
    private final int sender;//!3, littles
    private final int receiver;
    private final int amount;
    
    
    private static final PreparedStatement
            SELECT_PART_IN_TRANS, IS_TRANS_IN, SELECT_STATE;
    
    static {
        PreparedStatement selectPartInTrans, isTransIn, selectState;
        try {
            selectPartInTrans = Database.mkPS("SELECT sender, receiver, amount FROM transactions WHERE id = ?");
            isTransIn = Database.mkPS("SELECT COUNT(*) FROM transactions WHERE id = ?");
            selectState = Database.mkPS("SELECT state FROM transactions WHERE id = ?");
            
        } catch (final SQLException no) {
            selectPartInTrans = isTransIn = selectState = null;
            LG.error("The fail in a making of some prepared statements!", no);
            
        }
        
        SELECT_PART_IN_TRANS = selectPartInTrans;
        IS_TRANS_IN = isTransIn;
        SELECT_STATE = selectState;
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeAllOnTrans()));
        
    }
    
    
    public Transaction(final int sender, final int receiver, final int amount) {
        ID = COUNTER.getAndIncrement();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        
    }
    
    public Transaction(final int id) throws SQLException {
        ID = id;
        
        if (! exists()) throw new TransactionNonFound(String.format(
                "Such an %d transaction row is not in the table in the database!", id));
        
        SELECT_PART_IN_TRANS.setInt(1, id);
        final ResultSet rs = SELECT_PART_IN_TRANS.executeQuery();
        if (rs.next()) {
            sender = rs.getInt("sender");
            receiver = rs.getInt("receiver");
            amount = rs.getInt("amount");
            
        } else throw new TransactionNonFound(String.format(
                "The transaction %d was just-deleted at a running of this method!", id));
        
    }
    
    public static Transaction mkTransFromDB(final int id) throws SQLException {
        return new Transaction(id);
    }
    
    @Deprecated
    public Transaction() {
        this.ID = COUNTER.getAndIncrement();
        this.sender = this.receiver = this.amount = 0;
        
    }
    
    
    public boolean exists() throws SQLException {
        IS_TRANS_IN.setInt(1, ID);
        try (final ResultSet rs = IS_TRANS_IN.executeQuery()) {
            return rs.next() && rs.getInt(1) == 1;
        }
        
    }
    
    public TransactionState getState() throws SQLException {
        SELECT_STATE.setInt(1, ID);
        
        try (final ResultSet rs = SELECT_STATE.executeQuery()) {
            if (rs.next()) return TransactionState.values()[rs.getInt(1)];
            else return TransactionState.NOT_STARTED;
            
        }
        
    }
    
    
    public int getId() {
        return ID;
    }
    
    public int getSender() {
        return sender;
    }
    
    public int getReceiver() {
        return receiver;
    }
    
    public int getAmount() {
        return amount;
    }
    
    
    private static void closeAllOnTrans() {
        try (final PreparedStatement updateInBalance = SELECT_PART_IN_TRANS;
                final PreparedStatement isAccountIn = IS_TRANS_IN;
                final PreparedStatement selectBalance = SELECT_STATE) {}
        catch (final SQLException no) {
            LG.error("The fail in a closing of some resources!", no);
        }
        
    }
    
}
