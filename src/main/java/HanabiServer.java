import java.io.IOException;
import java.net.*;

public class HanabiServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(34522)){
            while(true) {
                Session session = new Session(server.accept());
                session.start();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
