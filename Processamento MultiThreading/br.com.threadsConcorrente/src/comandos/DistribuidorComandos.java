package comandos;

import runnables.ProcessarResultadoC2;
import servidor.ServidorTarefas;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuidorComandos {

    private String comandoRecebido;
    private PrintStream saidaParaCliente;
    private ExecutorService poolDeThreads;
    private BlockingQueue<String> filaComandos;
    private ServidorTarefas servidor;

    public DistribuidorComandos(String comandoRecebido, PrintStream saidaParaCliente,
                                ExecutorService poolDeThreads, BlockingQueue<String> filaComandos,
                                ServidorTarefas servidor) throws IOException, InterruptedException {
        this.comandoRecebido = comandoRecebido;
        this.saidaParaCliente = saidaParaCliente;
        this.poolDeThreads = poolDeThreads;
        this.filaComandos = filaComandos;
        this.servidor = servidor;
        this.chamarConsumidorComando();
    }

    private void chamarConsumidorComando() throws InterruptedException, IOException {
        switch (this.comandoRecebido.toLowerCase(Locale.ROOT)){
            case "c1" : saidaParaCliente.println("Confirmado comando c1");
                ComandoC1 comandoC1 = new ComandoC1(saidaParaCliente);
                this.poolDeThreads.execute(comandoC1);
                break;
            case "c2": saidaParaCliente.println("Confirmado comando c2");
                ComandoC2ChamaWebService comandoC2WS = new ComandoC2ChamaWebService(saidaParaCliente);
                ComandoC2AcessaBanco comandoC2BD = new ComandoC2AcessaBanco(saidaParaCliente);
                Future<String> retornoComandoWs = this.poolDeThreads.submit(comandoC2WS);
                Future<String> retornoComandoBd = this.poolDeThreads.submit(comandoC2BD);
                /**O método get do Future é BLOQUEANTE, por isso vamos fazer seu processamento
                 * em outra Thread*/
                this.poolDeThreads.submit(new ProcessarResultadoC2(retornoComandoBd,
                        retornoComandoWs,saidaParaCliente));
                break;
            case "c3":
                this.filaComandos.put(comandoRecebido);
                saidaParaCliente.println("Adicionando comando 'C3' a fila");
                break;
            case "finalizar": saidaParaCliente.println("Finalizando o servidor");
                this.servidor.finalizarServidor();
                break;
            default: saidaParaCliente.println("Comando não encontrado");
        }
    }
}
