package java8;

import java.util.Arrays;
import java.util.List;

/**
 * As lambdas tem como principal objetivo suprir a necessidade de ficar criando classes pequenas o
 * tempo inteiro e de maneira verbosa, deixando elas anonimas e delegando operações temos uma legibilidade
 * maior e um código mais elegante.
 * Para que uma lambda funcione, a classe anonima precisa implementar uma interface funcional, uma interface
 * funcional é uma interface que recebe Argumentos e devolve parâmetros compatíveis com a expressão lambda,
 * a expressão lambda consegue ser convertida em uma interface funcional.
 */
public class Lambdas {
    public static void main(String[] args) {

        List<String> listaPalavras = Arrays.asList("Jimim do BTS","Ratinho do ratinho", "Diogo Defante");

        /**Aqui eu estou usando uma lambda de comparação, onde eu apenas tenho uma linha de instrução,
         * repare que eu não preciso declarar a classe String, eu apenas passo meus argumentos e
         * digo que operação deve ser feita. Se eu não to declarando minha classe então ela está anonima
         * */
        listaPalavras.sort((palavra1, palavra2) -> palavra1.compareTo(palavra2));

        /**Aqui eu to usando uma Stream aliada a uma lambda, onde pra cada um dos argumentos eu vou dar um
         * replace e printar, como aqui eu tenho mais do que APENAS UMA LINHA de operação, eu preciso
         * abrir chaves"{}" */
        listaPalavras.forEach((palavra) -> {
            String palavraNova = palavra.replace(" ", "-");
            System.out.println(palavraNova);
        });

    }
}
