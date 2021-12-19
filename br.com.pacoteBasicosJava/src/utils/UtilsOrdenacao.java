package utils;

import modelos.Pessoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilsOrdenacao {
    public static void main(String[] args) {
    List<Pessoa> listaParaOrdenar = criarLista();

        System.out.println("Lista não ordenada: ");
        listaParaOrdenar.forEach(System.out::println);
        System.out.println("=======================================================");

        /**A interface List possuí um método de ordenação, mas esse método não sabe qual ordem utilizar,
         * então nós precisamos dizer para ele e fazemos isso através de uma classe
         * que implementa a interface Comparator(Olha a classe)*/
        listaParaOrdenar.sort(new IdadePessoaComparator());

        System.out.println("Lista ordenada por idade: ");
        listaParaOrdenar.forEach(System.out::println);
        System.out.println("=======================================================");

        System.out.println("Lista ordenada por nome:");
        /**Nada me impede de usar uma classe diferente para assinar um contrato de Comparator que
         * usa um critério diferente*/
        listaParaOrdenar.sort(new NomePessoaComparator());
        listaParaOrdenar.forEach(System.out::println);

        /**Usando uma lambda aqui como quem não quer nada, usando a classe Integer direto e me aproveitando
         * do comparator que ela assinou*/
        listaParaOrdenar.sort((p1,p2) -> Integer.compare(p1.getIdade(), p2.getIdade()));
}

    public static List<Pessoa> criarLista(){
        Pessoa pessoaUm = new Pessoa("Carlos Cruz", 44, "87654321");
        Pessoa pessoaDois = new Pessoa("Lucas", 22, "12345678");
        Pessoa pessoaTres = new Pessoa("Teresa Cristina", 19, "20202020");
        List<Pessoa> listaParaOrdenar = new ArrayList<>();
        listaParaOrdenar.add(pessoaDois);
        listaParaOrdenar.add(pessoaUm);
        listaParaOrdenar.add(pessoaTres);
        return listaParaOrdenar;
    };

}
