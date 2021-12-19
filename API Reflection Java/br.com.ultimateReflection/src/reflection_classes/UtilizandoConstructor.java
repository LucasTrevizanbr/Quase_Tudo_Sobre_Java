package reflection_classes;

import controladores.CidadeController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Nessa classe vamos aprender sobre a classe Constructor da api de Reflection, se uma class
 * infere sobre uma determinada classe, então o Constructor infere sobre o construtor de uma
 * determinada classe, o ideal é usar o Constructor em conjunto com a Class, sendo ele um complemento
 * para a mesma.
 */
public class UtilizandoConstructor {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**Esse é meu objeto Class inferindo sobre ControllerCidade onde vou utilizar métodos
         * do meu Constructor*/
        Class<CidadeController> controllerCidade = CidadeController.class;

        /**Usando o método getConstructor() sem passar argumentos eu estou dizendo para o meu Constructor
         * usar o construtor public de CidadeController sem parametros, SÓ FUNCIONA COM CONSTRUTORES
         * PUBLICOS*/
        Constructor<CidadeController> construtorPublicoDeCidadeController =
                controllerCidade.getConstructor();

        /**Também posso pegar um construtor que recebe parametros, onde eu preciso passar como argumento
         * o tipo que o construtor recebe, esse método de getDeclaredConstructor() serve para CONSTRUTORES
         * PRIVADOS*/
        Constructor<CidadeController> construtorPrivadoDeCidadeController =
                controllerCidade.getDeclaredConstructor(String.class);

        /**PARA CRIAR UM OBJETO A PARTIR DE UM CONSTRUTOR usamos o método newInstance*/
        CidadeController controller = construtorPublicoDeCidadeController.newInstance();

        /**Se quisermos instânciar um objeto a partir de um construtor privado antes temos que se
         * a acessibilidade para true*/
        construtorPrivadoDeCidadeController.setAccessible(true);
        /**Esse construtor pede um argumento, então precisamos passa-lo*/
        CidadeController controllerPrivado =
                construtorPrivadoDeCidadeController.newInstance("Preciso passar algo aqui");

        System.out.println(controllerPrivado);
        System.out.println(controller);



    }
}
