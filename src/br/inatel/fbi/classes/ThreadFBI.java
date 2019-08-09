package br.inatel.fbi.classes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ThreadFBI implements Runnable{
    private JLabel label;
    private JFrame estrada;
    private String nome;
    private boolean fim;
    private static boolean mostrouResultado;
    
    @Override
    public void run() {
        Random r = new Random();
        
        while(!fim){
            int n = r.nextInt(6);
            
            if((label.getX() + 170) < estrada.getWidth()) {
                label.setLocation(label.getX() + n, label.getY());
                estrada.repaint();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException ex) {
                }
            }
            else
                fim = true;
        }
        if(fim && !mostrouResultado) {
            mostrouResultado = true;
            if("FBI".equals(nome)) {
                JOptionPane.showMessageDialog(estrada, "O " + nome + " desarmou a bomba!");
                System.exit(0);
            }
            else {
                try {
                    AudioClip c = Applet.newAudioClip(new File("bombSound.wav").toURL());
                    c.play();
                    JOptionPane.showMessageDialog(estrada, "A " + nome + " foi plantada!");
                    System.exit(0);
                } catch (MalformedURLException e) {
                }
            }
        }
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setEstrada(JFrame estrada) {
        this.estrada = estrada;
    }
}
