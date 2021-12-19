package leitura_e_escrita_com_java;

import java.io.*;

/**
 * A primeira coisa que temos que entender ao ler um arquivo utilizando Java é que estamos lendo na verdade
 * um FLUXO DE ENTRADA, e esse FLUXO DE ENTRADA não são "letras/caracteres" são binários, esses binários
 * precisam ser convertidos em caracteres. Vamos fazer isso com alguns Objetos do Java, onde cada um deles
 * "embrulha" o outro para melhorar seu funcionamento(aliás, isso é um padrão chamado "Decorator")
 */
public class LerArquivoUm {

    public static void main(String[] args) throws IOException {

        /**O FileInputStream é uma classe que vai pegar o nosso fluxo de entrada de maneira binária,
         * ou seja, ele vai lá buscar esse meu arquivo e trazer os binários que representam ele*/
        FileInputStream fluxoEntradaBinariaDoArquivo = new FileInputStream("arquivoTeste.txt");

        /**Agora precisamos ler esses binários em uma linguagem humana né, então vamos usar um leitor
         * de Input para fazer isso, e esse leitor recebe o objeto de entradaBinária então estamos aplicando
         * o "decorator" aqui, afinal temos um objeto que melhorou o funcionamento de outro, um leitor
         * de input que transforma binários em caracteres*/
        InputStreamReader leitorBinarioParaCaractere = new InputStreamReader(fluxoEntradaBinariaDoArquivo);

        /**O nosso leitor agora tem ccaracteres, mas não é muito eficiente ler caractere por caractere,
         * ninguém lê assim. Então vamos continuar com o "decorator" e usar um BufferedReader, que
         * vai nos auxiliar para ler uma linha inteira invés de um caractere por vez*/
        BufferedReader leitorDeCaractereParaLinha = new BufferedReader(leitorBinarioParaCaractere);

        /**Agora sim usamos nosso objeto final para ler o arquivo de fato. E obviamente ele dispõe
         * de métodos para isso, um eles é o readLine() que lê APENAS uma linha do nosso arquivo
         * retornando nullo quando não acha algo para ler*/
        String linhaLida = leitorDeCaractereParaLinha.readLine();

        /**Sendo inteligente e sabendo que o método de linha retorna nullo quando não há nada para ler,
         * podemos usa-lo em um looping para ler um arquivo inteiro*/
        while(linhaLida!=null){
            System.out.println(linhaLida);
            linhaLida = leitorDeCaractereParaLinha.readLine();
        }

        /**E LEMBRE-SE se abrimos um FLUXO DE ENTRADA então precisamos fecha-lo*/
        leitorDeCaractereParaLinha.close();
    }
}
