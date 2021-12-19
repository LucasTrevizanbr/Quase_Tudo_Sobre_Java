package leitura_e_escrita_com_java;

import java.io.*;

public class CopiarArquivo {
    /**Se precisarmos copiar um arquivo basta ler a origem dele e escreve-lo em outro local*/
    public static void main(String[] args) throws IOException {

        /**Nosso leitor e escritor do arquivo*/
        BufferedReader leitor =
                new BufferedReader(new InputStreamReader(new FileInputStream("arquivoTeste.txt")));

        BufferedWriter escritor = new BufferedWriter(new FileWriter("arquivoCopiado.txt"));

        String linha = leitor.readLine();

        /**Escrevendo as linhas lidas de um arquivo para outro*/
        while(linha != null){
            escritor.write(linha);
            escritor.newLine();
            linha = leitor.readLine();
        }

        leitor.close();
        escritor.close();
    }
}
