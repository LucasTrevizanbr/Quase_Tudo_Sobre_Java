package leitura_e_escrita_com_java;

import java.io.*;

/**
 * Já vimos que na leitura de um Arquivo usamos bastante o padrão "decorator", isso pq precisamos
 * ler o fluxo em bytes e bites, depois transformar esse fluxo em caracteres e depois lelos com algum
 * Buffer. A escrita também não é diferente, vamos fazer o mesmo processo mas agora escrevendo.
 */
public class EscreverArquivoUm {

    public static void main(String[] args) throws IOException {

        /**Quem diria, um fluxo de saida se chama Output, e nosso objeto OutputStream é um
         * genérico para objetos específicos de saida de fluxo, nesse caso um FLUXO DE SAIDE DE ARQUIVO*/
        OutputStream fluxoDeSaidaBinario = new FileOutputStream("arquivoSaida1.txt");

        /**E aqui continuamos com o padrão decorator, eu vou ter um Escritor de saida, que vai
         * transformar meu fluxo binário de saida em caracteres, e um Buffered para que escreva linhas*/
        Writer escritorFluxoDeSaidaCaractere = new OutputStreamWriter(fluxoDeSaidaBinario);
        BufferedWriter escritorFluxoDeSaidaLinha = new BufferedWriter(escritorFluxoDeSaidaCaractere);

        escritorFluxoDeSaidaLinha.write("Sou uma nova linha escrita");
        escritorFluxoDeSaidaLinha.newLine();/**Especificando que agora eu quero uma nova linha*/
        escritorFluxoDeSaidaLinha.write("Sou uma linha escrita depois de usar o newLine()");

        /**Se abrimos um fluxo, é necessário que o fechemos*/
        escritorFluxoDeSaidaLinha.close();

        /**Aqui temos uma maneira mais enxuta de instanciar um BufferedWriter, onde no seu construtor
         * passamos diretamente uma instancia de FileWriter(classe especificada em escrever arquivos) */
        BufferedWriter escreverArquivoBuffered = new BufferedWriter(new FileWriter("arquivoSaidaDois.txt"));

    }
}
