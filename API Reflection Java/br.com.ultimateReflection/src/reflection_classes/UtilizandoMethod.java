package reflection_classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Obviamente se temos uma Class para inferir sobre uam classe e Constructor para inferir sobre um
 * construtor então teremos uma classe Method para inferir sobre métodos
 */
public class UtilizandoMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /**Apenas instânciando uma Class inferindo sobre CidadeController*/
        Class<?> cidadeControllerClass = Class.forName("controladores.CidadeController");

        /**Usando o método getMethods da classe Method no objeto Class, conseguimos buscar todos os
         * métodos PÚBLICOS que a classe inferida possui, inclusive métodos herdados, ou implementados
         * por alguma interface tanto que esse retorno aqui é enorme*/
        for(Method metodo : cidadeControllerClass.getMethods()){
            System.out.println(metodo);
        }

        System.out.println("===========================================================");

        /**Se eu quiser somente buscar os métodos que minha classe inferida tem, eu uso o getDeclaredMethods
         * INCLUSIVE AQUI EU TAMBÉM LISTO MÉTODOS PRIVADOS*/
        for (Method metodoDaClasseInferida : cidadeControllerClass.getDeclaredMethods()){
            System.out.println(metodoDaClasseInferida);
        }

        /**Sabemos listar métodos, agora vamos chama-los, pra isso precisamos de uma instância do objeto
         * que contém o método, podemos fazer isso com o Constructor*/
        Object cidadeControllerInstancia = cidadeControllerClass.getDeclaredConstructor().newInstance();

        /**Então agora vou capturar um método através de seu nome em um objeto Method*/
        Method metodoPublico = cidadeControllerClass.getDeclaredMethod("metodoSemParametro");

        /**Um objeto Method retorna um Object ao chamar invoke, que a propósito é o método que invoca
         * o método capturado em um Method, lembra do objeto instânciado que precisavamos? então, nós
         * o passamos como parâmetro de invoke para que ele saiba qual objeto tem o método a ser chamado,
         * esse método aqui é Publico e não recebe parâmetros*/
        Object retornoMetodoInvocado = metodoPublico.invoke(cidadeControllerInstancia);
        System.out.println(retornoMetodoInvocado +": Sou nullo pq não tenho retorno");

        /**E se eu quisesse acessar um método privado? é simples eu apenas passo minha flag de
         * true para setAcessible*/
        Method metodoPrivado =
                cidadeControllerClass.getDeclaredMethod("listar");
        metodoPrivado.setAccessible(true);

        Object retornoMetodoPrivadoInvocado = metodoPrivado.invoke(cidadeControllerInstancia);
        System.out.println("valor do objeto de retorno do método listar: "+retornoMetodoPrivadoInvocado);

    }
}
