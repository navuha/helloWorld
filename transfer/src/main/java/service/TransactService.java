package service;

import model.Account;
import model.Database;
import model.Transaction;
import io.vertx.core.json.Json;

import java.sql.SQLException;

import exception.TransactionNonDone;

public class TransactService implements Transact {
    public int transact(final String transactionJson) throws SQLException {
        final Transaction transaction = Json.decodeValue(transactionJson, Transaction.class);
        
        final int senderId = transaction.getSender(), amount = transaction.getAmount();
        if (amount <= 0) throw new TransactionNonDone(
                String.format("You can not make a transaction with the amount %d! Any amount > 0.",
                        amount));
        else if (new Account(senderId).getBalance() < amount)
            throw new TransactionNonDone(String.format("Account %d has non enough funds!",
                    senderId));
        
        final int id = transaction.getId();
        Database.insertIntoTransactions(id, senderId, transaction.getReceiver(), amount);
        
        return id;
        
    }
    
}
