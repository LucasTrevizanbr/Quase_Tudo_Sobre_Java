package principal;

import java.io.*;

/**
 * A serialização nada mais é do que transformar um objeto que está na memória em um fluxo
 * de bits e bytes, e ao contrário também.
 * Isso seria útil pensando em transferir o estado de um objeto de uma jvm para outra, como
 * um fluxo de dados.
 * Podemos usar as classes ObjectInputStream e ObjectOutputStream para trabalhar dessa maneira
 * Heap: memória onde objetos ficam
 */
public class OqueESerializacao {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Uma string é um objeto, então vamos serializa-lo com ajuda das classes
        String objetoParaSerializar = "Bolo";

        //O fluxo de saida precisa de um fluxo concreto, nesse caso estamos usando o fluxo de File
        ObjectOutputStream fluxoSerializacaoSaida = new ObjectOutputStream(new FileOutputStream("objeto.bin"));

        //Usamos o fluxo para transformar o objeto em um fluxo de bits e bytes e o File o grava
        fluxoSerializacaoSaida.writeObject(objetoParaSerializar);
        fluxoSerializacaoSaida.close();

        //Do mesmo modo podemos receber o objeto serializado com o input
        ObjectInputStream fluxoSerializacaoEntrada = new ObjectInputStream(new FileInputStream("objeto.bin"));
        String objetoDesserializado = (String) fluxoSerializacaoEntrada.readObject();
        fluxoSerializacaoEntrada.close();
        System.out.println(objetoDesserializado);

    }

}
