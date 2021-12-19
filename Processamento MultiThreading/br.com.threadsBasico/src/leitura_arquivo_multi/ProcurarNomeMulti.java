package leitura_arquivo_multi;

/**Essa é a classe principal que usaremos a programação multiThreading para buscar um nome específico
 * em arquivos com vários nomes de maneira paralela*/
public class ProcurarNomeMulti {
    public static void main(String[] args) {

        String nomeParaBuscar = "do";

        /**Declarando minhas Threads que serão executadas paralelamente, onde um nome será buscado
         * em 3 arquivos diferentes simultaneamente*/
        Thread threadBusca1 =
                new Thread(new TarefaMultiBuscaNome("assinaturas1.txt",nomeParaBuscar));
        Thread threadBusca2 =
                new Thread(new TarefaMultiBuscaNome("assinaturas2.txt",nomeParaBuscar));
        Thread threadBusca3 =
                new Thread(new TarefaMultiBuscaNome("autores.txt",nomeParaBuscar));

        /**Agora eu digo para a JVM trabalhar com essas representações de Thread paralelamente*/
        threadBusca1.start();
        threadBusca2.start();
        threadBusca3.start();
    }
}
