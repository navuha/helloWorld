package model;

public enum TransactionState {
    NOT_STARTED(0),
    STARTED(1),
    COMMITED(2);
    
    private final int VALUE;
    
    private TransactionState(final int value) {
        VALUE = value;
    }
    
    public int getValue() {
        return VALUE;
    }
    
}
