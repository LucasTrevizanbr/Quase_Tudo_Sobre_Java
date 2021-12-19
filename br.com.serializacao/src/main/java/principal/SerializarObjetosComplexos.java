package principal;

import objetos.Produto;
import objetos.Tenis;

import java.io.*;

/**
 * Serializando objetos próprios.
 * Se tentarmos usar o objectOutputStream para serializar um objeto complexo de uma maneira "crua"
 * recebemos uma exception de "objeto não pode ser serializado". Isso acontece porque o objeto não esta
 * implementando uma interface de Serializable.
 *
 * Ao salvar um objeto que é herança de um super, eu notei que o "preço"(atributo que vem da classe pai)
 * não foi gravado corretamente. Isso acontece pq a classe pai também deve implementar a interface
 * de Serializable e a interface implementada na classe pai pode ser Herdada pela classe filho sem
 * que haja a necessidade de explicita-la.
 *
 * Nesse ponto já notamos que as classes que se relacionam por agregação também devem
 * implementar a interface Serializable. Para ignorar classes que se relacionam e não queremos serializar
 * podemos usar a palavra reservada "transiente".
 *
 */
public class SerializarObjetosComplexos {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Tenis não implementa a interface Serializable, pois Produto ja implementa
        Produto bootDaora = new Tenis("Nike","Jordan II",650.00d);

        ObjectOutputStream fluxoSerializacaoSaida = new ObjectOutputStream(new FileOutputStream("tenis.bin"));
        fluxoSerializacaoSaida.writeObject(bootDaora);
        fluxoSerializacaoSaida.close();

        ObjectInputStream fluxoSerializacaoEntrada = new ObjectInputStream(new FileInputStream("tenis.bin"));
        Tenis objetoDesserializado = (Tenis) fluxoSerializacaoEntrada.readObject();
        fluxoSerializacaoEntrada.close();
        System.out.println(objetoDesserializado);

    }


}
