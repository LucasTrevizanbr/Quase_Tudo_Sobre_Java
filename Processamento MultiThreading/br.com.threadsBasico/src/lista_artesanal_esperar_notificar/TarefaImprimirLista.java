package lista_artesanal_esperar_notificar;

public class TarefaImprimirLista implements Runnable {

    private ListaAmadora listaAmadora;

    public TarefaImprimirLista(ListaAmadora listaAmadora) {
        this.listaAmadora = listaAmadora;
    }

    @Override
    public void run() {
        /**EU PRECISO ESTAR SINCRONIZADO PARA QUE O MEU AWAIT E NOTIFY CONVERSEM, PRECISO DO MUTEX(chave)
         * a minha chave é meu Objeto de lista, é nele que estou notificando alguém*/
        synchronized (listaAmadora) {
            esperar();
            for (int elemento = 0; elemento < listaAmadora.tamanho(); elemento++) {
                System.out.println(elemento + " - " + listaAmadora.pegaElemento(elemento));
            }
        }
    }

    /**TU VAI ESPERAR ATÉ SER NOTIFICADO(No caso minha lista syncronizada que vai notificar esse mano
     * aqui quando ela estiver preenchida)*/
    private void esperar() {
        try {
            /**EU PRECISO DEVOLVER A CHAVE PARA MINHA LISTA*/
            System.out.println("To esperando ser notificado");
            /**Vamos lembrar que uma execução de Thread é paralela e pode ser muito rápida, a ponto
             * de notificar antes da Thread esperar, vamos nos previnir*/
            if(!listaAmadora.estaCheia()){
                listaAmadora.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
