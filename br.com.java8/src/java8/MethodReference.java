package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * uma lambda simplesmente é "ME DA UM OBJETO E INVOCA ALGUM MÉTODO NESSE OBJETO".
 * Então nada me impede de simplesmente passar para minha lambda uma sintaxe
 * do tipo "String::length" ONDE EU SIMPLESMENTE ESTOU DIZENDO O OBJETO É STRING E VC VAI USAR O MÉTODO
 * LENGTH. E essa sintaxe é o MethodReference, e é importante saber que um methodReference só é valido
 * para uma única operação pequena, não inventa moda.
 */
public class MethodReference {
    public static void main(String[] args) {
        List<String> listaPalavras = Arrays.asList("Jimim do BTS","Ratinho do ratinho", "Diogo Defante");

        /**Fazer uma lambda dessa maneira*/
        listaPalavras.sort(Comparator.comparing(palavra -> palavra.length()));
        /**É equivalente a fazer esse processo, onde eu uso uma interface funcional que vai
         * receber uma string e devolver um inteiro, essa Function pode ser usada como argumento
         * de um Comparator*/
        Function<String, Integer> funcao = palavra -> palavra.length();
        Comparator<String> comparador = Comparator.comparing(funcao);
        listaPalavras.sort(comparador);

        /**Então eu posso simplesmente reduzir esse processo a uma referência do método length do
         * objeto String*/
        listaPalavras.sort(Comparator.comparing(String::length));

    }
}
