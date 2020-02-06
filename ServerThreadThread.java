package PeerToPeer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadThread extends Thread {

    private final ServerThread serverThread;
    private final Socket socket;
    private PrintWriter printeWriter;
    private ObjectOutputStream out;

    public ServerThreadThread(Socket socket, ServerThread serverThread) {
        this.serverThread = serverThread;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //pega a mensagem do peer connectado
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            //this.printeWriter = new PrintWriter(socket.getOutputStream(), true);
            this.out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                //manda para o peer de origem que aguardava a conexao
                serverThread.sendMessage(bufferedReader.readLine());
            }

        } catch (IOException ex) {
            serverThread.getServerThreadThreads().remove(this);
        }

    }

    public void output(Object message) throws IOException {
        out.writeObject(message);
    }

    public PrintWriter getPrintWriter() {
        return printeWriter;
    }

}
