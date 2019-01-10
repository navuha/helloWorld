import io.vertx.core.Vertx;
import org.apache.log4j.BasicConfigurator;

public class Transfer {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(TransferVerticle.class.getName());
        
    }
    
}
