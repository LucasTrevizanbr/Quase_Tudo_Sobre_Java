package encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/***
 * Unicode é uma tabela que tenta representar todos os caracteres do mundo com números, por exemplo
 * o caractere 'A' tem o valor 65 na tabela Unicode. Encodings são padrões utilizados para gravar
 * unicodes no físico(HD/SSD), esses padrões são: UTF-8, ASCII e etc...
 * No mundo de Java um caractere é mapeado pela tabela Unicode e transformado em um codePoint, a partir
 * desse codePoint o Java utiliza um padrão de Encoding para gravar no HD/SSD. Por padrão do Java o encoding
 * que ele utiliza depende do sistema operacional em que ele roda.
 */
public class UnicodeEnconding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        /**Se eu quiser saber o codePoint de um caractere eu posso utilizar o método codePointAt()*/
        String caractere = "A";
        System.out.println(caractere.codePointAt(0));

        /**Se eu quiser saber o Encoding padrão do sistema da minha aplicação posso utilizar a classe
         * Charset*/
        Charset conjuntoDeCaracteres = Charset.defaultCharset();
        System.out.println(conjuntoDeCaracteres.displayName());

        /**Quando falamos sobre escrita e leitura de arquivos, falamos sobre como eles são fluxos de
         * bytes antes de serem melhorados com outras classes utilizando o padrão "Decorator" até
         * virarem linhas legíveis. Pois bem, eu consigo pegar os bytes desse meu caractere*/
        byte[] bytesDoCaractere = caractere.getBytes();
        System.out.println(bytesDoCaractere.length);

        /**Outra coisa é útil é que podemos "forçar" o encoding que queremos usar nesses bytes*/
        byte[] bytesEscolhidos = caractere.getBytes("UTF-16");
        System.out.println(bytesEscolhidos.length + ", UTF-16");

        /**Também podemos usar o construtor de String para passar um conjunto de characteres para uma
         * String usando um deteminado padrão de encoding*/
        String novaString = new String(bytesDoCaractere, StandardCharsets.US_ASCII);
        System.out.println(novaString + " bytes em UTF-8 passados para ASCII");




    }
}
