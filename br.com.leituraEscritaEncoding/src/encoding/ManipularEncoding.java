package encoding;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Imagina só se tivermos que ler um arquivo cheio de assentos e caracteres especiais, imagina a dor
 * de cabeça de ter que lidar com linhas estranhas, seria muito bom se na hora de ler ele pudessemos
 * só dizer qual padrão de encoding  queremos usa, PODEMOS FAZER ISSO(e o mesmo se aplica na escrita);
 */
public class ManipularEncoding {
    public static void main(String[] args) throws IOException {
        /**Meu fluxo de entrada de bytes (inputStream) genérico vai utilizar um Input
         * em arquivos*/
        InputStream fluxoEntradaBytes = new FileInputStream("arquivoComAcentos.txt");

        /**Meu leitor genérico(Reader) vai receber um fluxoDeLeitura com meu fluxo de bytes e o
         * ENCODING que eu quero utilizar como parâmetro*/
        Reader leitorByteParaCaracter = new InputStreamReader(fluxoEntradaBytes, "UTF-8");

        /**Vamos ver o resultado*/
        BufferedReader leitorCaractereParaLinha = new BufferedReader(leitorByteParaCaracter);

        String linha = leitorCaractereParaLinha.readLine();

        while(linha != null){
            System.out.println(linha);
            linha = leitorCaractereParaLinha.readLine();
        }
        leitorCaractereParaLinha.close();

        /**Lemos com sucesso, agora vamos escrever um, meu escritor genérico(Writer) recebe um
         * escritor especifico(FileWriter) que no seu construtor tem o padrão de Encoding setado*/
        Writer escritorByteParaCaractere =
                new FileWriter("arquivoEscritoComAcentos.txt", StandardCharsets.UTF_8);
        BufferedWriter escritorFluxoDeSaidaLinha = new BufferedWriter(escritorByteParaCaractere);

        escritorFluxoDeSaidaLinha.write("Olá, vamos usar acentos, exclamações e interrogações!!");
        escritorFluxoDeSaidaLinha.newLine();
        escritorFluxoDeSaidaLinha.write("Saída? entrada? sei lá, só quero usar caracteres especiais");
        escritorFluxoDeSaidaLinha.newLine();
        escritorFluxoDeSaidaLinha.write("Aclimação? intrigante você!");

        escritorFluxoDeSaidaLinha.close();


    }
}
