package PeerToPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Peer {

    private Socket socket;
    private Cruzamento cruzamento;

    public static void main(String[] args) throws IOException {
        //recebe os dados do teclado
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("> Nome de usuário e a porta para este peer (ex.: ABC 4441)");
        String[] setupValues = bufferedReader.readLine().split(" "); //Pega os dados nome e depois do espaço a porta

        //cria o servidor desse peer e espera conexao com outros peers
        ServerThread serverThread = new ServerThread(setupValues[1]);
        serverThread.start();
        //cria um peer na rede
        new Peer().updateListenToPeers(bufferedReader, setupValues[0], serverThread);
    }

    public void updateListenToPeers(BufferedReader bufferedReader, String username, ServerThread serverThread) throws IOException {
        System.out.println("> digite o nome do host:porta(ex: 192.0.0.0:4445):");
        String input = bufferedReader.readLine();
        //guardar as informações dos host:porta que quer receber as mensagens
        String[] inputValues = input.split(" ");

        if (!input.equals("s")) {           
            for (String inputValue : inputValues) {
                //pega os endereços
                String[] adress = inputValue.split(":");
                Socket socket = null;
                try {
                    socket = new Socket(adress[0], Integer.valueOf(adress[1]));
                    new PeerThread(socket).start();
                } catch (IOException ex) {
                    if (socket != null) {
                        socket.close();
                    } else {
                        System.err.println("invalid input. skipping to next step.");
                    }
                }
            }

            //serverThread.sendMessage(dados);
            //mensagem a ser enviada para o peer
            System.out.println("s para continuar: ");
            String ok = bufferedReader.readLine();
//            this.cruzamento.iniciar();

        } 
        this.cruzamento = new Cruzamento();
        comunicate(bufferedReader, username, serverThread);
        this.cruzamento.iniciar();
       
    }
    public void comunicate(BufferedReader bufferedRead, String username,
            ServerThread serverThread) throws IOException {
        
        //sorteia a origem e velocidade
        Random random = new Random();
        int ori = (1 + random.nextInt(4));
        int dest = (1 + random.nextInt(4));
        int vel = (1 + random.nextInt(15));
        String origem = "A";
        String destino = "D";

        while (dest == ori) { //para que o destino nao seja a origem
            dest = (1 + random.nextInt(4));
        }
         if(ori == 1){
            origem = "A";            
        }if(ori == 2){
            origem = "B";            
        }if(ori == 3){
            origem = "C";            
        }if(ori == 4){
            origem = "D";            
        }
        if(dest == 1){
            destino = "A";            
        }if(dest == 2){
            destino = "B";            
        }if(dest == 3){
            destino = "C";            
        }if(dest == 4){
            destino = "D";            
        }
        String dados = username + ":" + origem + ":" + destino + ":" + vel;
        System.out.println(dados);
        
        System.out.println("enviar dados? SIM (s) NÃO (n)");

        boolean flag = true;
        while (flag) {
            //mensagem a ser enviada deste peer
            String message = bufferedRead.readLine();
            if (message.equals("s")) {
                serverThread.sendMessage(dados);
            } else {
                break;
            }
            System.out.println("enviar novamente? SIM (s) NAO (n)");
        }
//         this.cruzamento = new Cruzamento();
         String dado[] = dados.split(":");
          cruzamento.addCarro(dado[1], dado[2], Integer.valueOf(dado[3]));
         //cruzamento.addCarro(origem, destino, vel);
    }

    private class PeerThread extends Thread {

        private ObjectInputStream input;
        private final Socket socket;

        public PeerThread(Socket socket) throws IOException {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(PeerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean flag = true;
            while (flag) {

                try {
                    String dados = (String) input.readObject();
                    String dado[] = dados.split(":");
                    cruzamento.addCarro(dado[1], dado[2], Integer.valueOf(dado[3]));

                    System.out.println(dados);

                } catch (IOException ex) {
                    flag = false;
                    interrupt();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PeerThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
