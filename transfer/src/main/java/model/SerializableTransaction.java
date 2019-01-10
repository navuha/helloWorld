package model;

public class SerializableTransaction {
    public final int
            sender,//3, littles
            receiver,
            amount;
    
    
    public SerializableTransaction(final int sender, final int receiver, final int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        
    }
    
    @Deprecated
    public SerializableTransaction() {
        sender = receiver = amount = 0;
    }
    
}
