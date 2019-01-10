package model;

import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.AccountNonFound;

public class Account {
    private final static Logger LG = Logger.getLogger(Account.class);
    private final int ID;
    
    private static final PreparedStatement
            UPDATE_IN_BALANCE, IS_ACCOUNT_IN, SELECT_BALANCE;
    
    static {
        PreparedStatement updateInBalance, isAccountIn, selectBalance;
        try {
            updateInBalance = Database.mkPS("UPDATE accounts SET balance = ? WHERE id = ?");
            isAccountIn = Database.mkPS("SELECT COUNT(*) FROM accounts WHERE id = ?");
            selectBalance = Database.mkPS("SELECT balance FROM accounts WHERE id = ?");
            
        } catch (final SQLException no) {
            updateInBalance = isAccountIn = selectBalance = null;
            LG.error("The fail in a making of some prepared statements!", no);
            
        }
        
        UPDATE_IN_BALANCE = updateInBalance;
        IS_ACCOUNT_IN = isAccountIn;
        SELECT_BALANCE = selectBalance;
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> closeAllOnAccount()));
        
    }
    
    
    public Account(final int id) throws SQLException {
        this.ID = id;
        
        if (! this.exists()) throw new AccountNonFound(String.format(
                "Such an %d account row is not in the table in the database!", id));
        
    }
    
    
    public int getId() {
        return ID;
    }
    
    
    public void changeBalance(final int change) throws SQLException {
        UPDATE_IN_BALANCE.setInt(1, getBalance() + change);
        UPDATE_IN_BALANCE.setInt(2, ID);
        UPDATE_IN_BALANCE.executeUpdate();
        
    }
    
    public boolean exists() throws SQLException {
        IS_ACCOUNT_IN.setInt(1, ID);
        try (final ResultSet rs = IS_ACCOUNT_IN.executeQuery()) {
            return rs.next() && rs.getInt(1) == 1;
        }
        
    }
    
    public int getBalance() throws SQLException {
        SELECT_BALANCE.setInt(1, ID);
        try (final ResultSet rs = SELECT_BALANCE.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
            else throw new AccountNonFound(String.format(
                    "The fail in a retrieving of the balance in the account %d!", ID));
            
        }
        
    }
    
    
    private static void closeAllOnAccount() {
        try (final PreparedStatement updateInBalance = UPDATE_IN_BALANCE;
                final PreparedStatement isAccountIn = IS_ACCOUNT_IN;
                final PreparedStatement selectBalance = SELECT_BALANCE) {}
        catch (final SQLException no) {
            LG.error("The fail in a closing of some resources!", no);
        }
        
    }
    
}
