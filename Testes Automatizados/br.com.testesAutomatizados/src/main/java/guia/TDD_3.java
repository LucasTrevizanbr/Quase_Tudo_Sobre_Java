package guia;

public class TDD_3 {
    /**
     *                            Test Drive Development(TTD)
     *
     * Normalmente fazemos os testes depois de implementar uma funcionalidade. O TDD ou desenvolvimento
     * orientado a testes busca inverter essa ordem, onde primeiro escrevemos o teste da funcionalidade
     * e depois a implementamos.
     * Nesse caso o teste serve como um rascunho para o que vai ser a implementação, então escrevemos
     * pensando no comportamento que queremos, naturalmente esse teste tende a falhar e a partir desse
     * ponto a missão é refatorar até que os testes passem(Testar -> Implementar -> Refatorar).
     *
     * Uma das principais funcionalidades que o TDD proporciona é a refatoração do código, uma vez
     * que temos um cenário que passa nos testes podemos refatorar a vontade sem medo de quebrar algo.
     * Além de já sair com o código de implementação já testado e também evitamos testes viciados.
     *
     *                                       Exceções
     * Existe algumas maneiras de se lidar com Exception no Junit, você pode usar uma anotação de
     * (expected = classe de exceção lançada chamada literal), pode usar um assertThrows(classe esperada,
     * lambda com a chamada do método a ser testado), pode usar um Try catch onde se não cair na
     * exceção pode forçar uma falha chamando fail() e usar um Assert no catch combinando a mensagem
     * da exceção.
     *
     *                                     Anotações JUnit
     * Outras anotações uteis do Junit são a @BeforeEach, @AfterEach, @BeforeAll e @AfterAll.
     * Os nomes são muito didáticos e elas indicam que são ações que serão tomadas antes de efetuar
     * os métodos de teste, onde o EACH aplica o método anotado uma vez PARA CADA teste a ser executado
     * e o All uma vez  PARA TODOS os testes serem executados.
     * São anotações que ajudam a limpar o código de teste e facilitam algumas operações, evitando
     * código duplicado.
     *
     * Fiz o TDD aqui : "test.java.servico.CashBackBonusDataServico"
     */
}
