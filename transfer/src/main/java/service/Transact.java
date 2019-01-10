package service;

import java.sql.SQLException;

public interface Transact {
    public int transact(final String transactionDetails) throws SQLException;
}
