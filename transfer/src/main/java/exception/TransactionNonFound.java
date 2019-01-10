package exception;

import org.apache.log4j.Logger;

public class TransactionNonFound extends TransferFail{
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(TransactionNonFound.class);

    public TransactionNonFound(final String message) {
        super(message);
        LOGGER.error(message);
        
    }
    
}
