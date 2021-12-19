package bonus;

import java.util.concurrent.CountDownLatch;

public class TarefaProcessarBloco implements Runnable {

    private int idInicialBlocoThread;
    private int idFinalBlocoThread;
    private CountDownLatch contadorThread;

    public TarefaProcessarBloco(int idInicialBlocoThread, int idFinalBlocoThread,
                                CountDownLatch contadorThread) {

        this.idInicialBlocoThread = idInicialBlocoThread;
        this.idFinalBlocoThread = idFinalBlocoThread;
        this.contadorThread = contadorThread;
    }

    @Override
    public void run() {
            this.fazQualquerCoisa();
            /**Decrementa o contador de Threads o atualizando para os processos de controle*/
            this.contadorThread.countDown();
    }

    private void fazQualquerCoisa() {
        System.out.println("Processa ai");
    }
}
