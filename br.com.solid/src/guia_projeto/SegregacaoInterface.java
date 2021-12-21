package guia_projeto;

public class SegregacaoInterface {
    /***
     * Esse conceito eu vou ficar devendo uma implementação na prática, mas basicamente ele diz que
     * uma classe não deve ser forçada a depender de métodos que não utilizará.
     *
     * Um exemplo prático foi ter que implementar um método de dispararSemGerarTO numa interface
     * do projeto que trabalhei, esse método é específico para programas que utilizam a mensageria e
     * portanto não executavam de maneira síncrona impedindo de gerar um TO ao final do método.
     * Isso forçou os programas que não dependiam de mensageria a implementar esse método e ter que deixar
     * ele null, isso é uma péssima prática mas eu precisei fazer assim porque analista veio com isso do
     * NADA(não criou história pq esqueceu ou não sabia como funcionava esse cara, me forçando a ter
     * que pagar incendio)
     * O certo seria segregar essa Interface disparavel para uma nova Interface que lidava com a mensageria
     * especificamente, dessa maneira eu não teria métodos inutilizáveis em ambas as classes(tanto as de
     * mensagem como as que são síncronas).
     * Isso é o princípio de segregação de Interface!.
     *
     */
}
