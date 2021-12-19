package fabricas;

import tratadores_excecao.TratadorDeExcecao;

import java.util.concurrent.ThreadFactory;

/**Classe responsável por definir como minha pool irá instanciar suas Threads*/
public class FabricaDeThreads implements ThreadFactory {
    private static int numeroThread;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread Servidor de Tarefas " + numeroThread);
        numeroThread ++;
        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
        return thread;
    }
}
