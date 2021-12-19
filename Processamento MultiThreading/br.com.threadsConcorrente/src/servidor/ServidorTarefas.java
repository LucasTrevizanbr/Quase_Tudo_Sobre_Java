package servidor;

import fabricas.FabricaDeThreads;
import runnables.DistribuirTarefas;
import runnables.TarefaConsumirFila;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**Representa o servidor que irá receber as tarefas do cliente*/
public class ServidorTarefas {

    private ServerSocket socketServidor;
    private ExecutorService poolThreadServidor;
    private AtomicBoolean estaEmExecucao;
    private BlockingQueue<String> filaComandos;

    public ServidorTarefas() throws IOException {
        this.socketServidor = new ServerSocket(12345);
        this.poolThreadServidor = Executors.newCachedThreadPool(new FabricaDeThreads());
        this.estaEmExecucao = new AtomicBoolean(true);
        this.filaComandos = new ArrayBlockingQueue<>(2);
        this.iniciarConsumidoresFila();
    }

    private void iniciarConsumidoresFila() {
        int qtdConsumidores = 2;
        for(int i = 0; i<qtdConsumidores; i++){
            this.poolThreadServidor.execute(new TarefaConsumirFila(filaComandos));
        }
    }

    public void iniciarServidor() throws IOException {
        try{
            while(this.estaEmExecucao.get()){
                Socket socket = socketServidor.accept();
                System.out.println("Aceitando cliente na porta: "+socket.getPort());

                DistribuirTarefas distribuirTarefasDoCliente =
                        new DistribuirTarefas(socket, this, poolThreadServidor, filaComandos);
                poolThreadServidor.execute(distribuirTarefasDoCliente);
            }
        }catch (SocketException e){
            System.out.println("Socket Excepetion: "+this.estaEmExecucao);
        }
    }

    public void finalizarServidor() throws IOException {
        estaEmExecucao = new AtomicBoolean(false);
        socketServidor.close();
        poolThreadServidor.shutdown();
    }

}
