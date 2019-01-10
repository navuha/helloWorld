package exception;

import org.apache.log4j.Logger;

public class AccountNonFound extends TransferFail {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(AccountNonFound.class);

    public AccountNonFound(final String message) {
        super(message);
        LOGGER.error(message);
        
    }
    
}
