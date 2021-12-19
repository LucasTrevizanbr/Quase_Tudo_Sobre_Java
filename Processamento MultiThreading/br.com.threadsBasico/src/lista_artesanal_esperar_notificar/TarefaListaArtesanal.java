package lista_artesanal_esperar_notificar;

public class TarefaListaArtesanal implements Runnable {


    private ListaAmadora lista;
    private int numeroThread;

    public TarefaListaArtesanal(ListaAmadora lista, int numeroThread) {
        this.lista = lista;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for(int elemento = 0; elemento < 100; elemento++){
            lista.adicioanrElemento("Thread: "+numeroThread +" - "+elemento);
        }

    }
}
