package service;

import model.Database;
import model.Account;
import model.Transaction;
import model.TransactionState;

import org.apache.log4j.Logger;

import java.sql.SQLException;

public class CommitService implements Commit {
    private static final Logger LG = Logger.getLogger(Database.class);
    private String message;
    
    
    private void setMessage(final String message) {
        this.message = message;
        LG.debug(message);
        
    }
    
    
    public String commitTransaction(final int transactionId) throws SQLException {
        final Transaction transaction = Transaction.mkTransFromDB(transactionId);
        
        final String eoln = System.lineSeparator();
        if (transaction.getState() == TransactionState.COMMITED){
            setMessage(String.format("Transaction %d already commited!" + eoln, transactionId));
            return message;
            
        }
        
        final Account sender = new Account(transaction.getSender()),
                receiver = new Account(transaction.getReceiver());
        
        if (sender.exists() && receiver.exists()) {
            final int amount = transaction.getAmount();
            if (sender.getBalance() >= amount) {
                Database.setToAManCommit();
                
                sender.changeBalance(-amount);
                receiver.changeBalance(amount);
                
                Database.commitTrans(transactionId);
                
                setMessage(String.format("Transaction %d is done successfully!" + eoln, transactionId));
                
            } else setMessage(String.format("Account %d has non enough funds!" + eoln, transaction.getSender()));
            
        } else setMessage(String.format("One or both of the accounts %d and %d are not!" + eoln,
                transaction.getSender(), transaction.getReceiver()));
        
        return message;
        
    }
    
}
