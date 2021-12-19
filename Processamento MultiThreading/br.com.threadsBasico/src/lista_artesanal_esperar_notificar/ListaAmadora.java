package lista_artesanal_esperar_notificar;

import jdk.swing.interop.SwingInterOpUtils;

public class ListaAmadora {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicioanrElemento(String elemento){
        this.elementos[indice] = elemento;
        this.indice++;

        /**Quando meu idice for igual ao tamanho da minha lista ENTÃO ELE VAI NOTIFICAR A THREAD
         * que está ESPERANDO(TarefaImprimirLista)*/
        if(this.indice == this.elementos.length){
            System.out.println("Lista preenchida, notifica a Thread de impressão ai!");
            this.notify();
        }
    }

    public int tamanho(){
        return this.elementos.length;
    }

    public String pegaElemento (int posicao){
        return this.elementos[posicao];
    }

    public boolean estaCheia() {
        return this.indice == elementos.length;
    }
}
