package br.inatel.fbi.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;

public class ThreadInputStream extends Semaforo implements Runnable {
    
    private DefaultListModel mensagem;
    boolean fim;

    @Override
    public void run() {
        getSemaforo().tryAcquire();
        InputStream is;
        try {
            Thread.sleep(100);
            is = new FileInputStream("arquivo.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (!fim) {
                try {
                    String s = br.readLine();
                    while (s != null) {
                        mensagem.addElement(s);
                        s = br.readLine();
                    }
                    getSemaforo().release();
                } catch (IOException ex) {
                }
            }
        } catch (FileNotFoundException | InterruptedException ex) {
        }
    }

    public void setMensagem(DefaultListModel mensagem) {
        this.mensagem = mensagem;
    }
    
}
