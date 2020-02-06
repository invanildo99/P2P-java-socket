package PeerToPeer;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private final ServerSocket serverSocket;
    private static final ArrayList<ServerThreadThread> serverThreadsThreads = new ArrayList<>();

    public ServerThread(String porNumb) throws IOException {
        serverSocket = new ServerSocket(Integer.valueOf(porNumb));
    }

    @Override
    public void run() {
        try {
            while (true) {
                ServerThreadThread serverThreadThread;
                //outros peers que irão se conectar
                serverThreadThread = new ServerThreadThread(serverSocket.accept(), this);

                serverThreadsThreads.add(serverThreadThread);

                serverThreadThread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Envia mensagens para todos os serverThreads(os peers) ja connectados
     *
     * @param message mensagens a ser enviado
     */
    void sendMessage(String message) throws IOException {
        Iterator interator = serverThreadsThreads.iterator();
        while (interator.hasNext()) {
            ServerThreadThread peer = (ServerThreadThread) interator.next();
            //peer.getPrintWriter().println(message);
            peer.output(message);
        }
    }

    public ArrayList<ServerThreadThread> getServerThreadThreads() {
        return serverThreadsThreads;
    }

}
