package leitura_e_escrita_com_java;

import modelos.Cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Agora iremos ler um tipo de arquivo que contém informações específicas separadas por ","
 * como eu comentei na introdução. Esse arquivo possui o tipo da conta e alguns dados como
 * agencia, conta, nome e saldo.
 * Nossa tarefa aqui vai ser ler os dados de um arquivo .csv e atribui eles a uma lista de objetos
 * de Clientes.
 */
public class LerArquivoDois {
    public static void main(String[] args) throws FileNotFoundException {

        List<Cliente> clientesLidosDoArquivo = new ArrayList<>();

        /***Vamos então usar o Objeto Scanner, ele é mais genérico e vai interpretar
         * o objeto de input que passarmos que nesse caso é um Objeto que representa o fluxo
         * de entrada de um arquivo/File. Um ponto importante é não passar o caminho
         * do arquivo para um Scanner, use um Objeto.*/
        Scanner scannerGenerico = new Scanner(new File("contas.csv"));

        /**Para fazer o que enunciamos precisamos ser capazes de interpretar as informações contidas
         * na linha do arquivo. O Scanner também pode nos ajudar nisso, basta instanciarmos um novo
         * Scanner, esse Scanner novo é para ler e interpretar especificamente uma LINHA
         * do arquivo, enquanto o Scanner inicial lê o arquivo INTEIRO*/
        while(scannerGenerico.hasNextLine()){
            String linha = scannerGenerico.nextLine();

            /**Passo a minha linha lida para o meu Scanner de linha*/
            Scanner scannerDeLinha = new Scanner(linha);
            /**Com o delimitador eu digo: "Ei, separa as palavras dessa linha por "x" coisa"*/
            scannerDeLinha.useDelimiter(",");

            /**Agora eu pego meus valores já delimitados e os atribuo a variáveis*/
            String tipoConta = scannerDeLinha.next();
            int agencia = Integer.valueOf(scannerDeLinha.next());
            int numeroConta = Integer.valueOf(scannerDeLinha.next());
            String nomeTitular = scannerDeLinha.next();
            Double saldo = Double.valueOf(scannerDeLinha.next());

            /**Seto os dados lidos como atributos de um objeto de cliente*/
            Cliente cliente = new Cliente();
            cliente.setTipoConta(tipoConta);
            cliente.setAgencia(String.format("%04d",agencia));
            cliente.setNumeroConta(String.format("%04d",numeroConta));
            cliente.setNomeTitular(nomeTitular);
            cliente.setSaldo(saldo);

            System.out.println("Linha convertida em objeto: "+linha);

            clientesLidosDoArquivo.add(cliente);
        }
        scannerGenerico.close();

        System.out.println(clientesLidosDoArquivo);

    }
}
