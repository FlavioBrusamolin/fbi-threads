package br.inatel.fbi.classes;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ThreadKeyLogger extends Semaforo implements Runnable {

    @Override
    public void run() {
        getSemaforo().tryAcquire();
        Scanner teclado = new Scanner(System.in);
        try {
            PrintStream ps = new PrintStream("arquivo.txt");
            while (teclado.hasNextLine()) {
                String texto = teclado.nextLine();
                ps.println(texto);
            }
            getSemaforo().release();
        } catch (FileNotFoundException ex) {
        }
    }

}
