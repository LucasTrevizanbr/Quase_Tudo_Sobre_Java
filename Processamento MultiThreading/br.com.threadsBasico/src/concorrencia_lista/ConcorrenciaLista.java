package concorrencia_lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcorrenciaLista {
    public static void main(String[] args) throws InterruptedException {
        /**Podemos usar um método de Collections ou a classe Vector*/
        List<String> listaDeCompra = Collections.synchronizedList(new ArrayList<String>());

        for(int threads = 0; threads < 10 ; threads++){
            Thread thread = new Thread(new TarefaAdicionarProduto(listaDeCompra, threads));
            thread.start();
        }

        Thread.sleep(2000);

        listaDeCompra.forEach(System.out::println);
    }
}
