package reflection_melhor_pratica;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Classe para lidar com métodos que minha class vai poder inferir.
 */
public class ManipuladorMetodo {

    /**Relembrando que precisamos ter um Method e um Objeto instanciado para poder invocar métodos de
     * maneira reflexiva, nada mais justo que minha classe manipuladora de métodos então os tenha*/
    private Object instancia;
    private Method metodo;
    private Map<String, Object> parametros;

    public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> parametros) {
        this.instancia = instancia;
        this.metodo = metodo;
        this.parametros = parametros;
    }


    /**Eu quero que meu manipuladorMetodo seja capaz de invocar um método né, então eu vou ter
     * um método nele que faz issso*/
    public Object invocaMetodo(){
        try {
            /**Agora eu passo meus argumentos para meu método selecionado*/
            List<Object> parametrosMetodoASerInvocado = new ArrayList<>();

            /**Então eu pego os parametros do meu método e para cada um deles eu recupero
             * do meu Map e adiciona em uma lista*/
            Stream.of(metodo.getParameters()).forEach(parametro ->
                    parametrosMetodoASerInvocado.add(parametros.get(parametro.getName())));

            /**Envio minha lista com os parametros para o método a ser invocado*/
            return metodo.invoke(instancia, parametrosMetodoASerInvocado.toArray());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no invocaMétodo: "+e);
        }
    }





}
