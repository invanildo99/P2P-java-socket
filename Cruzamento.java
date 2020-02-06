/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeerToPeer;

import java.awt.Component;
import static java.lang.Thread.sleep;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author IVANILDO
 */
public final class Cruzamento extends JFrame {

    private static String rotaCarro1;
    private static String rotaCarro2;
    private static String rotaCarro3;
    private static String rotaCarro4;

    private static String origemCarro1;
    private static String origemCarro2;
    private static String origemCarro3;
    private static String origemCarro4;

    private static String destinoCarro1;
    private static String destinoCarro2;
    private static String destinoCarro3;
    private static String destinoCarro4;

    private static int velocidadeCarro1;
    private static int velocidadeCarro2;
    private static int velocidadeCarro3;
    private static int velocidadeCarro4;
    private int numeroCar = 0;

    private final JLabel lCruzamento;
    private static JLabel lCarro1;
    private static JLabel lCarro2;
    private static JLabel lCarro3;
    private static JLabel lCarro4;

    ImageIcon Carro1 = new ImageIcon(getClass().getResource("t.png"));
    ImageIcon Carro2 = new ImageIcon(getClass().getResource("f.png"));
    ImageIcon Carro3 = new ImageIcon(getClass().getResource("c.png"));
    ImageIcon Carro4 = new ImageIcon(getClass().getResource("b.png"));

    public Cruzamento() {
        ImageIcon imagemFundo = new ImageIcon(getClass().getResource("pista.png"));
        this.lCruzamento = new JLabel(imagemFundo); // imagem do cruzamento
        this.lCruzamento.setBounds(0, 0, 889, 530); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    public void iniciar() {
        setVisible(true);
        add(this.lCruzamento);

        if (numeroCar > 0) {
            new Movimento().start();
        }
    }

    public void addCarro(String origem, String destino, int velocidade) {
        switch (this.numeroCar) {
            case 0:
                switch (origem) {
                    case "A": {
                        Cruzamento.lCarro1 = new JLabel((Icon) Carro1);
                        lCarro1.setBounds(0, 260, 61, 28);
                        break;
                    }
                    case "B": {
                        Cruzamento.lCarro1 = new JLabel((Icon) Carro1);
                        lCarro1.setBounds(850, 320, 61, 28);
                        break;
                    }
                    case "C": {
                        Cruzamento.lCarro1 = new JLabel((Icon) Carro1);
                        lCarro1.setBounds(445, 0, 61, 28);
                        break;
                    }
                    case "D": {
                        Cruzamento.lCarro1 = new JLabel((Icon) Carro1);
                        lCarro1.setBounds(440, 500, 61, 28);
                        break;
                    }
                    default:
                        break;
                }   
                origemCarro1 = origem;
                destinoCarro1 = destino;
                rotaCarro1 = origem.concat(destino);
                velocidadeCarro1 = velocidade;
                add(lCarro1);
                numeroCar++;
                break;
            case 1:
                switch (origem) {
                    case "A": {
                        Cruzamento.lCarro2 = new JLabel((Icon) Carro2);
                        lCarro2.setBounds(0, 260, 61, 28);
                        break;
                    }
                    case "B": {
                        Cruzamento.lCarro2 = new JLabel((Icon) Carro2);
                        lCarro2.setBounds(850, 320, 61, 28);
                        break;
                    }
                    case "C": {
                        Cruzamento.lCarro2 = new JLabel((Icon) Carro2);
                        lCarro2.setBounds(445, 0, 61, 28);
                        break;
                    }
                    case "D": {
                        Cruzamento.lCarro2 = new JLabel((Icon) Carro2);
                        lCarro2.setBounds(400, 500, 61, 28);
                        break;
                    }
                    default:
                        break;
                }   
                origemCarro2 = origem;
                destinoCarro2 = destino;
                rotaCarro2 = origem.concat(destino);
                velocidadeCarro2 = velocidade;
                add(lCarro2);
                numeroCar++;
                break;
            case 2:
                switch (origem) {
                    case "A": {
                        Cruzamento.lCarro3 = new JLabel((Icon) Carro3);
                        lCarro3.setBounds(0, 260, 61, 28);
                        break;
                    }
                    case "B": {
                        Cruzamento.lCarro3 = new JLabel((Icon) Carro3);
                        lCarro2.setBounds(850, 320, 61, 28);
                        break;
                    }
                    case "C": {
                        Cruzamento.lCarro3 = new JLabel((Icon) Carro3);
                        lCarro3.setBounds(445, 0, 61, 28);
                        break;
                    }
                    case "D": {
                        Cruzamento.lCarro3 = new JLabel((Icon) Carro3);
                        lCarro3.setBounds(400, 500, 61, 28);
                        break;
                    }
                    default:
                        break;
                }   
                origemCarro3 = origem;
                destinoCarro3 = destino;
                rotaCarro3 = origem.concat(destino);
                velocidadeCarro3 = velocidade;
                add(lCarro3);
                numeroCar++;
                break;
            case 3:
                switch (origem) {
                    case "A": {
                        Cruzamento.lCarro4 = new JLabel((Icon) Carro4);
                        lCarro4.setBounds(0, 260, 61, 28);
                        break;
                    }
                    case "B": {
                        Cruzamento.lCarro4 = new JLabel((Icon) Carro4);
                        lCarro4.setBounds(850, 320, 61, 28);
                        break;
                    }
                    case "C": {
                        Cruzamento.lCarro4 = new JLabel((Icon) Carro4);
                        lCarro4.setBounds(445, 0, 61, 28);
                        break;
                    }
                    case "D": {
                        Cruzamento.lCarro4 = new JLabel((Icon) Carro2);
                        lCarro4.setBounds(400, 500, 61, 28);
                        break;
                    }
                    default:
                        break;
                }   
                origemCarro4 = origem;
                destinoCarro4 = destino;
                rotaCarro4 = origem.concat(destino);
                velocidadeCarro4 = velocidade;
                add(lCarro4);
                numeroCar++;
                break;
            default:
                break;
        }
    }

    public class Movimento extends Thread {

        @Override
        public void run() {
            while (true) {

                if (Cruzamento.lCarro1 != null) {
//                    car1();
                    try {
                        sleep(velocidadeCarro1);
                    } catch (InterruptedException erro) {

                    }
                    //DB
                    if ("DB".equals(rotaCarro1)) {
                        lCarro1.setBounds(lCarro1.getX() + 1, 325, 61, 28);
                    }
                    //DA
                    if ("DA".equals(rotaCarro1)) {
                        if (lCarro1.getX() < 445) {
                            lCarro1.setBounds(lCarro1.getX() + 1, 325, 61, 28);
                        } else {
                            lCarro1.setIcon(Carro4);
                            lCarro1.setBounds(460, lCarro1.getY() - 1, 28, 61);
                        }
                    }
                    //DC
                    if ("DC".equals(rotaCarro1)) {
                        if (lCarro1.getX() < 380) {
                            lCarro1.setBounds(lCarro1.getX() + 1, 325, 61, 28);
                        } else {
                            lCarro1.setIcon(Carro3);
                            lCarro1.setBounds(400, lCarro1.getY() + 1, 28, 61);
                        }
                    }
                }
                if (Cruzamento.lCarro2 != null) {
//                    car2();
                    try {
                        sleep(velocidadeCarro2);
                    } catch (InterruptedException erro) {

                    }
                    //BD
                    if ("BD".equals(rotaCarro2)) {
                        lCarro2.setBounds(lCarro2.getX() - 1, 260, 61, 28);
                    }
                    //BA
                    if ("BA".equals(rotaCarro2)) {
                        if (lCarro2.getX() > 470) {
                            lCarro2.setBounds(lCarro2.getX() - 1, 260, 61, 28);
                        } else {
                            lCarro2.setIcon(Carro4);
                            lCarro2.setBounds(470, lCarro2.getY() - 1, 28, 61);
                        }
                    }
                    //BC
                    if ("BC".equals(rotaCarro2)) {
                        if (lCarro2.getX() > 420) {
                            lCarro2.setBounds(lCarro2.getX() - 1, 260, 61, 28);
                        } else {
                            lCarro2.setIcon(Carro3);
                            lCarro2.setBounds(400, lCarro2.getY() + 1, 28, 61);
                        }
                    }
                }
                if (Cruzamento.lCarro3 != null) {
//                    car3();
                    try {
                        sleep(velocidadeCarro3);
                    } catch (InterruptedException erro) {

                    }
                    //AC
                    if ("AC".equals(rotaCarro3)) {
                        lCarro3.setBounds(460, lCarro3.getY() + 1, 28, 61);
                    }
                    //AD
                    if ("AD".equals(rotaCarro3)) {
                        if (lCarro3.getY() < 250) {
                            lCarro3.setBounds(460, lCarro3.getY() + 1, 28, 61);
                        } else {
                            lCarro3.setIcon(Carro2);
                            lCarro3.setBounds(lCarro3.getX() - 1, 270, 61, 28);
                        }
                    }
                    //AB
                    if ("AB".equals(rotaCarro3)) {
                        if (lCarro3.getY() < 320) {
                            lCarro3.setBounds(460, lCarro3.getY() + 1, 28, 61);
                        } else {
                            lCarro3.setIcon(Carro1);
                            lCarro3.setBounds(lCarro3.getX() + 1, 320, 61, 28);
                        }
                    }
                }
                if (Cruzamento.lCarro4 != null) {
//                    car4();
                    try {
                        sleep(velocidadeCarro4);
                    } catch (InterruptedException erro) {

                    }
                    //CA
                    if ("CA".equals(rotaCarro4)) {
                        lCarro4.setBounds(400, lCarro4.getY() - 1, 28, 61);
                    }
                    if ("CA".equals(rotaCarro4)) {
                        if (lCarro4.getY() > 275) {
                            lCarro4.setBounds(460, lCarro4.getY() - 1, 28, 61);
                        } else {
                            lCarro4.setIcon(Carro2);
                            lCarro4.setBounds(lCarro4.getX() - 1, 265, 61, 28);
                        }
                    }
                    if ("CA".equals(rotaCarro4)) {
                        if (lCarro4.getY() > 320) {
                            lCarro4.setBounds(460, lCarro4.getY() - 1, 28, 61);
                        } else {
                            lCarro4.setIcon(Carro1);
                            lCarro4.setBounds(lCarro4.getX() + 1, 320, 61, 28);
                        }
                    }
                }

                if (bateu(lCarro1, lCarro2)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
                if (bateu(lCarro1, lCarro3)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
                if (bateu(lCarro1, lCarro4)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
                if (bateu(lCarro2, lCarro3)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
                if (bateu(lCarro2, lCarro4)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
                if (bateu(lCarro3, lCarro4)) {
                    JOptionPane.showMessageDialog(null, "Bateu!");
                    System.exit(0);
                }
            }
        }
    }

    //Metodo que verifica se um carro bateu no outro
    public boolean bateu(Component a, Component b) {
        int aX = a.getX();
        int aY = a.getY();
        int ladoDireitoA = aX + a.getWidth();
        int ladoEsquerdoA = aX;
        int ladoBaixoA = aY + a.getHeight();
        int ladoCimaA = aY;

        int bX = b.getX();
        int bY = b.getY();
        int ladoDireitoB = bX + b.getWidth();
        int ladoEsquerdoB = bX;
        int ladoBaixoB = bY + b.getHeight();
        int ladoCimaB = bY;

        boolean bateu = false;

        boolean cDireita = false;
        boolean cCima = false;
        boolean cBaixo = false;
        boolean cEsquerda = false;

        if (ladoDireitoA >= ladoEsquerdoB) {
            cDireita = true;
        }
        if (ladoCimaA <= ladoBaixoB) {
            cCima = true;
        }
        if (ladoBaixoA >= ladoCimaB) {
            cBaixo = true;
        }
        if (ladoEsquerdoA <= ladoDireitoB) {
            cEsquerda = true;
        }

        if (cDireita && cEsquerda && cBaixo && cCima) {
            bateu = true;
        }

        return bateu;
    }
}
