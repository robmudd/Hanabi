import java.net.*;
import java.util.*;
import java.io.*;

public class HanabiClient {
    private static final String SERVER_ADDRESS= "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try(
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                ) {
            System.out.printf("");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
