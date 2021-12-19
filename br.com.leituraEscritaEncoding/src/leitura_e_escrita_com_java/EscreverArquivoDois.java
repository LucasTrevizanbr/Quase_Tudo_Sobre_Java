package leitura_e_escrita_com_java;

import modelos.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**Agora vamos aplicar a mesma ideia da leitura, mas escrevendo, onde o objetivos é transformar uma
 * lista de objetos em um arquivo csv*/
public class EscreverArquivoDois {

    private static List<Cliente> listaDeClientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        /**Podemos usar um printWriter para escrever arquivos também*/
        PrintWriter printarFluxo = new  PrintWriter("contasEscrita.csv");

        listaDeClientes = instanciarClientes(listaDeClientes);

        /**Iterando sobre a lista e a escrevendo com uma lambda que utiliza nosso printWriter*/
        listaDeClientes.forEach((cliente) ->{
            /**Aqui temos uma familiaridade com esses métodos print, usamos ele bastante quando queremos ver
             * algo no consolo, o conceito é o mesmo alias, mas agora estamos escrevendo em um arquivo*/
            printarFluxo.print(cliente.getTipoConta());
            printarFluxo.print(",");
            printarFluxo.print(cliente.getAgencia());
            printarFluxo.print(",");
            printarFluxo.print(cliente.getNumeroConta());
            printarFluxo.print(",");
            printarFluxo.print(cliente.getNomeTitular());
            printarFluxo.print(",");
            printarFluxo.print(cliente.getSaldo().toString());
            printarFluxo.println();
        });

        /**ja usei meu escritor, fecho o fluxo*/
        printarFluxo.close();
    }

    private static List<Cliente> instanciarClientes(List<Cliente> lista){
        lista.add(new Cliente("CC","22","33", "Lauro Rodrigo",210.1));
        lista.add(new Cliente("CP","11","55", "Cleopatra Silva",1300.98));
        lista.add(new Cliente("CC","22","44", "Alexandre Roberto",350.40));

        return lista;
    }
}
