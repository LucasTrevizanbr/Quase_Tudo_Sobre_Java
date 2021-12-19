package runnables;

import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ProcessarResultadoC2 implements Runnable {

    private Future<String> retornoComandoBd;
    private Future<String> retornoComandoWs;
    private PrintStream saidaParaCliente;

    public ProcessarResultadoC2(Future<String> retornoComandoBd,
                                      Future<String> retornoComandoWs,
                                      PrintStream saidaParaCliente) {
        this.retornoComandoBd = retornoComandoBd;
        this.retornoComandoWs = retornoComandoWs;
        this.saidaParaCliente = saidaParaCliente;
    }

    @Override
    public void run() {
        System.out.println("Aguardando resultado do processamento C2-WS e C2-BD");

        try {
            /**Eu posso passar um tempo limite para o meu Future pegar seu resultado*/
            String numeroRetornadoWS = this.retornoComandoWs.get(15, TimeUnit.SECONDS);
            String numeroRetornadoBD = this.retornoComandoBd.get(15, TimeUnit.SECONDS);


            this.saidaParaCliente.println("Resultado comando C2-BD: "+numeroRetornadoBD);
            this.saidaParaCliente.println("Resultado comando C2-WS: "+numeroRetornadoWS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            System.out.println("Timeout: Cancelando execução do comando 'C2'");
            this.saidaParaCliente.println("Timeout na execução comando C2");
            /**Se ele não pegar no tempo que eu estimei, posso mandar que ele CANCELE A EXECUÇÃO e
             * interrompa a Thread*/
            this.retornoComandoWs.cancel(true);
            this.retornoComandoBd.cancel(true);
        }
        System.out.println("Terminou o Processamento dos Resultados do comando 'C2'");

    }
}
