package runnables;

import java.util.Locale;
import java.util.concurrent.BlockingQueue;

public class TarefaConsumirFila implements Runnable {

    private BlockingQueue<String> filaComandos;

    public TarefaConsumirFila(BlockingQueue<String> filaComandos) {
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {

        try {
            /**enquanto tiver comando na fila bota pra torar*/
            String comando = null;
            while((comando = this.filaComandos.take()) != null){
                System.out.println("Consumindo comando: "+comando.toUpperCase(Locale.ROOT)+" "
                        + Thread.currentThread().getName());
                Thread.sleep(10000);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
