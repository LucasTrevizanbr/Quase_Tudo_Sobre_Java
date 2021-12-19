package comandos;

import java.io.PrintStream;

public class ComandoC1 implements Runnable{

    private PrintStream saidaParaCliente;

    public ComandoC1(PrintStream saidaParaCliente) {
        this.saidaParaCliente = saidaParaCliente;
    }

    @Override
    public void run() {
        System.out.println("Executando comando 'c1'");
        /**Simulando uma tarefa demorada*/
        dormir(20000);
        saidaParaCliente.println("Comando 'c1' executado com Sucesso");
        System.out.println("Comando 'C1' finalizado.");

    }

    private void dormir(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
