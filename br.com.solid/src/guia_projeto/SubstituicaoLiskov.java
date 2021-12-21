package guia_projeto;

public class SubstituicaoLiskov {
    /**
     *                                          Cenário
     *
     * Agora eu quero que minhas tarefas tenham o fator adiconar pontos extras, isso vai ocorrer
     * pelo ENUM que tem a dificuldade da tarefa/quanto mais dificil mais pontos extras a tarefa da.
     * Minhas classes responsáveis por essa lógica vão ficar em "service.adicionar_pontos", basicamente
     * se a tarefa tiver sido concluída, então com base na sua dificuldade, ela ganha pontos extras
     * Mas agora EU DECIDI QUE EU QUERO TER UMA TAREFA PARCEIRA, ela é uma tarefa de parceria com alguma
     * outra marca/setor qualquer coisa, por ser uma parceira ela não esta elegível a ganhar pontos extras
     * iguais as minhas tarefas, quem defini a quantidade extra é o parceiro.
     *
     * Mas inconscientemente eu pensei em  extender essa TarefaParceira da minha Tarefa já que
     * elas possuem os mesmos dados, MAS FAZENDO ISSO EU PERMITO QUE ELA SEJA USADA EM MEUS MÉTODOS PARA
     * UMA TAREFA e isso é UMA PÉSSIMA PRÁTICA.
     * Então o que eu posso fazer se a herança nesse caso não é a minha melhor opção? Eu tenho uma
     * TarefaParceira que apenas terá um atributo de pontos extras do parceiro mas os outros serão iguais
     * a uma Tarefa comum.
     *
     * Nesse caso eu posso usar COMPOSIÇÃO(Extrair os atributos comum entre classes em outra classe,
     * e então usar essa classe como atributo das outras que partilham esses atributos). Agora a minha
     * TarefaParceira não é mais UMA TAREFA ela TEM DADOS QUE UMA TAREFA TEM (isso evita código duplicado,
     * e é uma boa prática em programação OO, priorizar Composição à Herança).
     *
     * ===================Princípio da Substituição de Liskov========================================
     * Acabemos de aplicar o Princípio da substituição de Liskov, o que acontecia é que meu método
     * de adicionar pontos extras esperava receber uma Tarefa do meu domínio e pra isso faria o
     * comportamento esperado. Mas minha TarefaParceira não está interessada na maneira como eu adiciono
     * pontos extras, ela já tem esse seu valor, se ela herdasse da minha Tarefa ela seria elegível
     * para passar por esse método de adição de pontos extras.
     *
     * Fora o fato de que eu teria métodos herdados da minha Tarefa que não fazem sentido nenhum dentro
     * da TarefaParceira, a única coisa que realmente ambas tinham em comum são os dados que tornavam
     * ambas uma representação de Tarefa.
     *
     * Continue aqui: InversaoDependencia
     *
     */
}
