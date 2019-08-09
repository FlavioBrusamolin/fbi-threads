package br.inatel.fbi.classes;

import java.util.concurrent.Semaphore;

public class Semaforo {
    
    private Semaphore semaforo;

    public void setSemaforo(Semaphore semaforo) {
        this.semaforo = semaforo;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }
    
}
