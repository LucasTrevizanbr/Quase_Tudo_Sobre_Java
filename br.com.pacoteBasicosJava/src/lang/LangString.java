package lang;

import java.util.Locale;

/**Strings também são objetos, como tudo em java.*/
public class LangString {
    public static void main(String[] args) {
        /**Mesmo sendo um objeto não precisamos do new para instancia-la, podemos usar uma object literal*/
        String frase = "Sou um objeto de string instanciado de forma literal";

        /**Obviamente por ser um objeto temos uma série de métodos que podemos usar, e aqui entra o
         * conceito mais interessante de Strings, elas são imutáveis, então métodos que modificam uma
         * String na verdade retornam um novo objeto de String*/
        String fraseNovaRetornada = frase.toUpperCase(Locale.ROOT);
        System.out.println(fraseNovaRetornada);

        /**Um objeto de String conta com uma série de métodos úteis para filtragem e formatação,
         * e até mesmo utilidade para algumas regras de negócio, isso é um tópico mais avançado e que
         * cabe junto com REGEX*/
        String s = fraseNovaRetornada.replace("LITERAL","Literal");
        System.out.println(s);


    }
}
