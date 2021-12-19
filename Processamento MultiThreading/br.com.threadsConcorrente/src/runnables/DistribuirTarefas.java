package runnables;

import comandos.DistribuidorComandos;
import servidor.ServidorTarefas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**Classe responsável por distribuir as tarefas do cliente de acordo com o comando passado*/
public class DistribuirTarefas implements Runnable{

    private ServidorTarefas servidor;
    private ExecutorService poolDeThreads;
    private BlockingQueue<String> filaComandos;
    private Socket socket;


    public DistribuirTarefas(Socket socket, ServidorTarefas servidorTarefas,
                             ExecutorService poolThreadServidor, BlockingQueue<String> filaComandos) {
        this.socket = socket;
        this.servidor = servidorTarefas;
        this.poolDeThreads = poolThreadServidor;
        this.filaComandos = filaComandos;
    }

    @Override
    public void run() {

        try {
            Scanner lerEntradaCliente = new Scanner(socket.getInputStream());
            PrintStream saidaParaCliente = new PrintStream(socket.getOutputStream());

            while (lerEntradaCliente.hasNextLine()) {
                String comandoRecebido = lerEntradaCliente.nextLine();
                System.out.println("Comando recebido: " + comandoRecebido);

                DistribuidorComandos chamarComando = new DistribuidorComandos(comandoRecebido,
                        saidaParaCliente, poolDeThreads, filaComandos,servidor);
            }

            lerEntradaCliente.close();
            saidaParaCliente.close();

        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
