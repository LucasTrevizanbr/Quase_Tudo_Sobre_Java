package metaprogramacao;

public class InjecaoDependenciaInversaoControle {
    /**
     * Temos uma classe que tem mocks das nossas cidades, para que não precisemos fazer uma conexão
     * com algum banco de dados. Estamos usando essa classe como um atributo do Controller de cidade
     * e inicializando ela no construtor.
     * O ponto aqui é o seguinte, nosso Controller não tem que saber instanciar esse gerador de objetos,
     * ele só precisa dos métodos dele. Então eu não quero instanciar isso na minha classe, eu quero apenas
     * receber esse gerador por parâmetro e usar sua instância.
     * Então quem é responsável por criar uma instância do nosso ControllerCidade também vai ser responsável
     * por nos dar uma instância do GeradorObjetos. Isso é INVERSÃO DE CONTROLE, eu tiro o controle
     * da criação do GeradorObjetos do CidadeController e passo esse controle pra quem CRIAR UMA INSTÂNCIA
     * DE CidadeController. Isso nos trás outro conceito que é a INJEÇÃO DE DEPENDÊNCIA, a minha
     * CidadeController vai receber POR INJEÇÃO as classes que ela precisa(GeradorObjetos). Quem cria o
     * CidadeController vai ser responsável por INJETAR AS DEPENDÊNCIAS dela.
     *
     * ============================Container IOC ========================================================
     * A gente sabe quem alguém tem que dar o GeradorObjetos pra nossa classe, esse alguém geralmente
     * é um Container IOC/container de inversão de controle(um container responsável por nos dar
     * objetos que precisamos via Injeção)
     * Esse nosso cara ta aqui: "container.ContainerIoC" -> Usamos Reflection de um jeito bem legal aqui.
     * Com o container criado, agora vamos refatorar o método do ControladorDeRota.
     * Agora quem instância nosso Controller é o container. Esse container consegue instanciar os objetos
     * que o construtor da classe precisa, ENTÃO AGORA VAMOS PASSAR A DEPENDÊNCIA DO GeradorObjetos que
     * a CidadeController tem como PARÂMETRO DO SEU CONSTRUTOR, e já receberemos ela instanciada.
     *
     * ==================================Melhorando=================================================
     * Até esse ponto a gente recebia uma instância do GeradorObjetosMock, mas agora eu quero deixar isso
     * ainda mais genérico, quero receber uma instância de GeradorObjetos apenas(sim, uma interface
     * que a implementação fica por conta de quem estiver utilizando, então agora eu posso receber
     * meus dados de cidade de um banco de dados, um mock ou qualquer outra coisa).
     * O que acontece agora com o container é que se ele se mantiver do jeito que estava ele ia dar ruim,
     * pq uma INTERFACE NÃO POSSUI CONSTRUTOR. Usando um Mapa onde a classe destino está vinculada com a
     * classe fonte(olha o ContainerIoC) eu consigo resolver isso, MAS EU PRECISO QUE MEU CONTROLADOR DE
     * ROTAS faça esse link entre a Interface e o Objeto concreto(olhar o método main e o Controlador de
     * Rotas).
     * ========================================Generics==============================================
     * Para finalizar bem, vamos trazer o Generics pra pauta. Nós fazemos a verificação do tipoFonte
     * com o destino(alteração pra fazer o container lidar com interfaces e supertipos) somente
     * em tempo de execução, agora queremos que logo ao "registrar" os tipos(etapa do controlador
     * de rotas) a ide nos avise em tempo de compilação que pode dar errado.
     * Tipos Genericos é um recurso que permite parametrizar informações para uma determina classe
     * (Tipo fazer uma List<String>).
     * Então no meu container eu posso dizer através dos generics que meu tipo T eu não sei o que é
     * mas meu tipo K OBRIGATORIAMENTE DEVE EXTENDER DE T(veja a implementação na classe ContainerIoC).
     *
     *
     */
}
