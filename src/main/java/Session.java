import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Session extends Thread{
    private final Socket socket;

    public Session (Socket socketForClient) {
        this.socket = socketForClient;
    }

    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(this.socket.getInputStream());
            DataOutputStream output = new DataOutputStream((this.socket.getOutputStream()));

            while(true) {
                String msg = input.readUTF();
                output.writeUTF(msg);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
