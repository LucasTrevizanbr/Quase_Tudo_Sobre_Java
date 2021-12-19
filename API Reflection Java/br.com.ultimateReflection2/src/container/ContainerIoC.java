package container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

/**Essa classe vai ser responsável por devolver nossas instâncias que iremos injetar. Vamos
 * usar os conceitos de Reflection que vimos até agora*/
public class ContainerIoC {

    /**Precisamos lidar com a questão de precisar instanciar um tipo Interface, então vamos usar um mapa
     * onde a chave é o tipoFonte(a interface) e o valor vai ser o tipoDestino(a classe concreta que
     * implementa a Interface)*/
    private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte){

        /**Verifico se o tipoFonte já esta vinculado a algum tipoDestino no meu mapa*/
        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
        if(tipoDestino != null){
            return getInstancia(tipoDestino);
        }

        /**Começamos pegando todos os construtores da classe fonte*/
        Stream<Constructor<?>> construtoresDoTipoFonte =
                Stream.of(tipoFonte.getDeclaredConstructors());


        /**Vou filtrar meus construtores atrás daquele que não tem parâmetros(vulgo construtor Default)*/
        Optional<Constructor<?>> construtorPadrao =
                construtoresDoTipoFonte.filter((construtor)  -> construtor.getParameterCount() == 0)
                .findFirst();

        try{
            /**Se tiver um construtor padrão, então instância e devolve a instância*/
            if(construtorPadrao.isPresent()){
                Object instancia = construtorPadrao.get().newInstance();
                return instancia;

            }else{
                /**Se não tivermos um construtor padrão então eu pego o primeiro da lista de construtores,
                 * afinal de contas se eu não tenho um padrão então qualquer um serve.*/
                Constructor<?> construtor = tipoFonte.getDeclaredConstructors()[0];

                /**Então aqui eu vou só instanciar as classes com o tipo que esse construtor qualquer
                 * ai pede*/
                List<Object> parametros = new ArrayList<>();
                for(Parameter parametro : construtor.getParameters()){

                    /**Pega o tipo do parametro, joga na Class*/
                    Class<?> tipoDoParametro = parametro.getType();
                    /**Devolve a instância do tipo do parametro usando nosso proprio método*/
                    parametros.add( getInstancia(tipoDoParametro));
                }

                /**Devolve o construtor qualquer passando as instancias do parametro que pegamos*/
                return construtor.newInstance(parametros.toArray());
            }

        }catch (InvocationTargetException | InstantiationException |
                IllegalAccessException  e ){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**Usamos na assinatura o T e tipo K(Generics), ainda não conseguimos saber que tipo eles são
     * mas podemos definir algumas regras pra eles. Como por exemplo dizer que K deve extender
     * de T, e isso elimina  o código de verificação de compatibilidade kkkk*/
    public <T,K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {

        mapaDeTipos.put(tipoFonte,tipoDestino);

        /*Não preciso mais
        boolean compativel = verificarCompatibilidade(tipoFonte, tipoDestino);
        if(compativel){
            mapaDeTipos.put(tipoFonte,tipoDestino);
        }else{
            throw new ClassCastException("Não é possível resolver "+ tipoFonte.getName()
            +" para "+tipoDestino.getName());
        }*/
    }

    //Também não preciso mais
    private boolean verificarCompatibilidade(Class<?> tipoFonte, Class<?> tipoDestino) {
        boolean compativel ;

        /* Verificação na raça
        if(tipoFonte.isInterface()){
            /**Verifica se o tipo destino implementa alguma interface que seja a do tipo fonte
            compativel = Stream.of(tipoDestino.getInterfaces())
            .anyMatch(interfaceImplementada -> interfaceImplementada.equals(tipoFonte));

        }else{
            /**Aqui eu já sei que meu tipo fonte não é uma interface, nesse caso ele sendo uma classe
             * concreta eu preciso verificar se são objetos compativeis atraves de herança ou se são
             * a mesma coisa

            /**verifica se o meu tipoDestino é filho do meu tipo fonte ou se são o mesmo objeto
            compativel = tipoDestino.getSuperclass().equals(tipoFonte)
            || tipoDestino.equals(tipoFonte);
        } */

        /**Verificando com a API de reflection*/
        return tipoFonte.isAssignableFrom(tipoDestino);
    }
}
