package exception;

import java.sql.SQLException;

abstract class TransferFail extends SQLException {
    private static final long serialVersionUID = 1L;
    
    TransferFail(final String message) {
        super(message);
    }
    
}
