package comandos;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String> {

    private PrintStream saida;

    public ComandoC2AcessaBanco(PrintStream saida) {
        this.saida = saida;
    }

    @Override
    public String call() throws InterruptedException {
        System.out.println("Servidor Recebeu o comando 'C2'-BD");
        saida.println("Processando comando 'C2 -BD'");

        /**Simulando uma tarefa demorada*/
        Thread.sleep(20000);
        int numeroAleatorio = new Random().nextInt(1000) + 1;

        saida.println("Comando 'C2'-BD executado com Sucesso");
        return Integer.toString(numeroAleatorio);
    }
}
