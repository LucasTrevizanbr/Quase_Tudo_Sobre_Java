package concorrencia_lista;

import java.util.List;

public class TarefaAdicionarProduto implements Runnable {

    private List<String> produtos;
    private int numeroThread;

    public TarefaAdicionarProduto(List<String> produtos, int numeroThread) {
        this.produtos = produtos;
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        for (int produto = 0; produto < 10; produto++) {
            String[] produtosParaAdicionar =
                    {"Arroz","Feijao","Macarrao","Amendoim","Desinfetante","Sabão","Detergente","Frango"
                    ,"Carne","Leite"};
            produtos.add("Thread número: "+numeroThread+" - "+produtosParaAdicionar[produto]);
        }
    }
}
