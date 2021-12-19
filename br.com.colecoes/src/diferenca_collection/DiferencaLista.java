package diferenca_collection;

import modelo.Soldado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Listas são basicamente classes auxiliares para se trabalhar com coleções de dados.
 * Lists respeitam a ordem de inserção e permitem elementos repetidos:
 *
 * ArrayList: Ela consegue fazer umas operações de maneira muito eficiente, como invocar o método get(indice)
 * Se você precisa pegar o décimo quinto elemento, ele te devolve isso bem rápido.
 * Onde uma ArrayList é lenta? Quando você for, por exemplo, inserir um novo elemento na primeira posição.
 * Pois a implementação vai precisar mover todos os elementos que estão no começo da lista para a próxima
 * posição.
 *
 * LinkedList: Ela utiliza a estrutura de dados chamada lista ligada. Ela é muito rápida para adicionar
 * e remover elementos na cabeça da lista, isso é, na primeira posição.
 * Mas ela é lenta se você precisar acessar um determinado elemento, pois a implementação precisará percorrer
 * todos os elementos até chegar ao décimo quinto, por exemplo.
 */
public class DiferencaLista {
    public static void main(String[] args) {
        Soldado soldadoUm = new Soldado(100, 15, "Guerreiro");
        Soldado soldadoDois = new Soldado(65, 30, "Arqueiro");
        Soldado soldadoTres = new Soldado(120, 8, "Escudeiro");

        List<Soldado> listaDeSoldados = new ArrayList<>();
        listaDeSoldados.add(soldadoUm);
        listaDeSoldados.add(soldadoDois);
        listaDeSoldados.add(soldadoTres);

        //Ordenando com o comparator usando uma lambda
        listaDeSoldados.sort(Comparator.comparing(Soldado::getPontosDeVida).reversed());
        listaDeSoldados.forEach(System.out::println);
    }

}
