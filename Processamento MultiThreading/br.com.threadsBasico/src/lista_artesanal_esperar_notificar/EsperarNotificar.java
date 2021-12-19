package lista_artesanal_esperar_notificar;

import concorrencia_lista.TarefaAdicionarProduto;

public class EsperarNotificar {
    public static void main(String[] args) throws InterruptedException {

        ListaAmadora listaAmadora = new ListaAmadora();

        for(int threads = 0; threads < 10 ; threads++){
            Thread thread = new Thread(new TarefaListaArtesanal(listaAmadora, threads));
            thread.start();
        }

        new Thread(new TarefaImprimirLista(listaAmadora)).start();
    }
}
