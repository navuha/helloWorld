package service;

import java.sql.SQLException;

public interface Commit {
    String commitTransaction(final int transactionId) throws SQLException;
}
