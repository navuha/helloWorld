package exception;

import org.apache.log4j.Logger;

public class TransactionNonDone extends TransferFail {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(TransactionNonDone.class);

    public TransactionNonDone(final String message) {
        super(message);
        LOGGER.error(message);
        
    }
    
}
