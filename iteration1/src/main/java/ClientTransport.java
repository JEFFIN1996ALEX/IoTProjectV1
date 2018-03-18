import java.io.*;
        import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientTransport {
    private static Socket socket;

    public void SendToServer(String number){


        try {
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);

            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            String sendMessage = number + "\n";
            bw.write(sendMessage);
            System.out.println("Message sent to the server : "+sendMessage);
            bw.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopSocket()
    {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String RcvFromServer() {

        InputStream is = null;
        String message = null;
        try {

            is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            message = br.readLine();
            System.out.println("Message received from the server : " + message);
            System.out.println("************************************************");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}
