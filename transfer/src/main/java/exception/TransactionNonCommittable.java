package exception;

import org.apache.log4j.Logger;

public class TransactionNonCommittable extends TransferFail {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(TransactionNonCommittable.class);

    public TransactionNonCommittable(final String message) {
        super(message);
        LOGGER.error(message);
        
    }
    
}
