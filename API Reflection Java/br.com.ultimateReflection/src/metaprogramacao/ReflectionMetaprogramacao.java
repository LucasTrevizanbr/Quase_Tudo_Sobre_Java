package metaprogramacao;

public class ReflectionMetaprogramacao {
    /**
     * Algumas situações da programação envolvem um cenário onde precisamos lidar com dados/informações
     * extremamente dinâmicas, situações onde não sabemos como nosso código em tempo de desenvolvimento
     * irá se comportar.
     * Um exemplo, que inclusive vamos utilizar na prática, é uma api que recebe request
     * e devolve respostas(imaginando o cenário web) onde não sabemos quais classes teremos que
     * manipular de acordo com a url de requisição que recebemos.
     * Então precisamos de "alguma coisa" que lide com informações dinâmicas que só teremos acesso em tempo
     * de execução, essa "alguma coisa" é a METAPROGRAMAÇÃO que nada mais é que um código que consegue
     * olhar/inferir dentro de outro código(isso vai ficar mais claro).
     * Para lidar com a METAPROGRAMAÇÃO em Java nós temos a API de Reflection, que nos permite manipular
     * classes e métodos de classes de maneira inferida/metaprogramatica.
     *
     * ==Principais classes da Reflection=====
     * Aqui precisamos ir para um outro pacote onde entenderemos como utilizar a reflexão.
     * Esse pacote é "reflection_classes." É PRIMORDIAL PASSAR POR AQUI ANTES DE OLHAR O EXEMPLO PRÁTICO
     *
     * ==Simulando chamadas com o clientSide====
     * Agora que já conhecemos as principais classes de reflexão podemos emular um request que virá
     * do client side, e através desse request em forma de url vamos utilizar reflexão para saber o que
     * fazer com ele. Para conhecer esse simulador de request, vamos usar o pacote "emulador_client_side."
     *
     * ==Usando de fato a reflection com melhores práticas ===
     * Para entender o método "executa" do ControladorDeRota que é nosso PRINCIPAL MÉTODO, temos que
     * entender a estrutura por trás do pacote "reflection_melhor_pratica." onde temos uma série
     * de classes para manipular cada componente" de reflection de uma maneira organizada e funcional.
     * Basicamente falando eu tenho um conjunto de classes para manipular a reflexão de uma Class iferida.
     *
     * ==Enfim o método executa do ControladorDeRota ===
     * Agora sabemos tudo o que precisamos para entrar nesse método principal, onde a magia da reflexão
     * acontece, ela centraliza tudo o que precisamos para lidar com uma url de requisição, o método
     * executa esa na classe ControladorDeRota no pacote "emulador_client_side."
     * Também aprimoramos nossos chamados de métodos utilizando parametros que talvez ele possa receber;
     *
     */
}
