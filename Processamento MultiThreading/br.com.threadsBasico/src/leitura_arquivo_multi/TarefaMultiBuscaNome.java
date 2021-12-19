package leitura_arquivo_multi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**Classe com a tarefa que será executada pela Thread que a chamar*/
public class TarefaMultiBuscaNome implements Runnable {

    private String nomeArquivo;
    private String nomePessoa;
    private boolean temNomeBuscado;

    public TarefaMultiBuscaNome(String nomeArquivo, String nomePessoa) {
        this.nomeArquivo = nomeArquivo;
        this.nomePessoa = nomePessoa;
    }

    @Override
    public void run() {
        /**Para ler um arquivo temos que abri-lo e escanea-lo linha a linha, pra isso podemos
         * usar um Scanner decorado com um File(Scanner pra arquivo), agora lemos todas as linhas e
         * vemos se ela contém o nome que estamos buscando, se tiver então imprimimos com o número da linha*/
        try {
            this.temNomeBuscado = false;
            Scanner scaner = new Scanner(new File(this.nomeArquivo));

            int numeroLinha = 1;

            while(scaner.hasNextLine()){
                String linha = scaner.nextLine();

                if(linha.toLowerCase(Locale.ROOT).contains(this.nomePessoa.toLowerCase())){
                    System.out.println(nomeArquivo + " - " + linha + " - linha número: "+numeroLinha);
                    this.temNomeBuscado = true;
                }

                numeroLinha++;
            }

            scaner.close();

            if(!temNomeBuscado){
                System.out.println(nomeArquivo + " Não tem o nome : "+this.nomePessoa );
            }

        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }

    }
}
