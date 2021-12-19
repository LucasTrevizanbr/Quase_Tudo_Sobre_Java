package reflection_classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Já utilizamos a classe Method para invocar um método que recebe parâmetro, mas a fins didáticos
 * vamos reforçar o exemplo.
 */
public class UtilizandoMethodComParametro {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /**Cria objeto de Class inferindo a classe CidadeController*/
        Class<?> cidadeControllerClass = Class.forName("controladores.CidadeController");

        /**Pegando o construtor da classe inferida no objeto Class*/
        Constructor<?> cidadeControllerConstrutor = cidadeControllerClass.getDeclaredConstructor();

        /**Instanciando enfim o objeto inferido em Class através do construtor recuperado */
        Object cidadeController = cidadeControllerConstrutor.newInstance();

        /**Buscando o método pelo nome, note que aqui a gente usa a Class, como esse método que queremos
         * buscar utiliza parametro, então passamos também o tipo de parametro*/
        Method metodo = cidadeControllerClass.getDeclaredMethod("buscarCidadePorNome", String.class);
        /**Esse método é privado então eu o torno acessível:*/
        metodo.setAccessible(true);
        /**Invoco meu método passando a instância do objeto que o contém, e meu argumento*/
        Object cidadeRetornado = metodo.invoke(cidadeController,"São Paulo");

        System.out.println(cidadeRetornado);

    }
}
