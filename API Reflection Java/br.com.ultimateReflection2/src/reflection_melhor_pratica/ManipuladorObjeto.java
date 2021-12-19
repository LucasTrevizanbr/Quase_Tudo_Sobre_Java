package reflection_melhor_pratica;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Classe responsável por manipular objetos finais iferidos na Class.
 */
public class ManipuladorObjeto {

    /**Se eu quero manipular um Object então eu terei ele na minha classe*/
    private Object instancia;

    /**Vou garantir de somente poder instanciar meu manipulador com uma instância*/
    public ManipuladorObjeto(Object instancia) {
        this.instancia = instancia;
    }

    /**Para usar o método dessa minha instância eu vou entrega-lo para um manipulador de Metodos
     * Agora que eu recebo meus parametros eu tenho que trata-los:*/
    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> parametros) {
        /** No tratamento dos meus parâmetros eu preciso garantir algumas coias:
         * 1) O método tem que ter o mesmo nome informado pelo usuário na url de requisição;
         * 2) O método precisa ter a mesma quantidade de parametros passado na url pelo usuário;
         * 3)os parametros do método precisam ter o MESMO NOME E TIPO dos parametros passados na url
         * pelo usuário, por exemplo:
         *
         * /cidade/buscarCidadePorNome?nome=nome  => buscarCidadePorNome(String nome)
         * /cidade/listar =>  listar()
         * Isso é uma tarefa ardua, mas vamos usar Streams para nos auxiliar
         */

        /**Pego todos os métodos da minha Instancia e transformo em uma stream de Methods*/
        Stream<Method> metodosDaInstancia = Stream.of(instancia.getClass().getDeclaredMethods());

        /**Agora começo o processo de filtragem dessa Stream de Methods*/
        Method metodoSelecionado = metodosDaInstancia.filter(
                /**Comparando se o nome do meu método sendo iterado é igual ao passado pela url*/
                metodoSendoIterado -> metodoSendoIterado.getName().equals(nomeMetodo)
                        /**Se a quantidade de parametros do meu método sendo iterado é igual a qtd de parametros
                         * do meu Map*/
                        && metodoSendoIterado.getParameterCount() == parametros.values().size()
                        /**E agora o mais complexo, se os métodos tem o mesmo nome e tipo,
                         * Começo fazendo uma stream do método sendo iterado e pegando todos seus parâmetros
                         * e vendo se todos eles são iguais allMatch() aos*/
                        && Stream.of(metodoSendoIterado.getParameters()).allMatch(
                        /**Parametros do método que eu possuo nas chaves do meu map de métodos */
                        parametrosDoMetodo -> parametros.keySet().contains(parametrosDoMetodo.getName())
                                /**E também se eles tem o mesmo tip, meu método presente no map e o parametro do método que eu to
                                 * iterando*/
                                && parametros.get(parametrosDoMetodo.getName()).getClass().equals(parametrosDoMetodo.getType())
                )
        )
                /**Então eu pego o primeiro e como ele é um Optional posso lançar uma exceção caso não o ache*/
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Método não encontrado!"));
                metodoSelecionado.setAccessible(true);

        return new ManipuladorMetodo(instancia, metodoSelecionado, parametros);
    }

}
