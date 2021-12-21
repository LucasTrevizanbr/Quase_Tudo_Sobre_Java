package guia_projeto;

public class AbertoFechado {
    /**
     *                                          Cenário
     *
     *  Temos agora que colocar uma regra adicional de que uma tarefa pode ter os pontos reajustados
     *  em um intervalo de pelo menos 6 meses, regra implementada então show de bola.
     *  Mas agora eu parei pra pensar em algo, eu se eu tiver mais umas 15 regras de reajuste?(burocracia
     *  para dificultar pro meu funcionário) eu teria que implementar todas elas nessa classe de
     *  ReajusteService e ela ainda se manteria coesa, mas ai ela tende a ficar muito grande, se essas
     *  regras começarem a ficar complexas vão ter mais código ainda.
     *  E se eu precisar tirar uma dessas 15 regras? Ai eu vou ter que voltar num código antigo e correr
     *  o risco de quebrar algo, PQP E AGORA?.
     *  Já sei, eu posso extrair as regras desse único método de reajuste em outras classes, já que cada uma
     *  dessas classes vai validar uma regra em específico, então eu posso CRIAR UMA INTERFACE de validação
     *  que possui um método em comum que é validar() e minhas classes específicas vão assinar essa
     *  interface e cada uma aplica sua validação concreta. Agora meu ReajusteService pode ter uma lista
     *  de ValidacaoReajuste que pode ter N regras, e apenas chamo elas na hora de efetuar o reajuste.
     *  Com isso minha classe de ReajusteService se tornou extendivel e fácil de se refatorar, EU NÃO
     *  PRECISO ADICIONAR MAIS REGRAS NO MEU MÉTODO PRINCIPAL DE REAJUSTE, eu simplesmente recebo uma
     *  lista de Interface de validação que minhas CLASSES CONCRETAS COM VALIDAÇÕES DISTINTAS IMPLEMENTAM
     *  e agora eu posso ALTERAR QUALQUER REGRA, OU ADICIONAR UMA NOVA OU EXCLUIR SEM ALTERAR MINHA CLASSE
     *  DE SERVICE.
     *
     * ===========================ReajusteService- Principio aberto fechado===============================
     *  Acabamos de aplicar o Principio "OpenClose/AbertoFechado". Nossa classe de ReajusteService
     *  pode receber novas regras e ela NÃO PRECISA SER ALTERADA. Ela está ABERTA para receber novas
     *  extensões e FECHADA para modificações. O legal aqui é que nosso Service só sabe de um "conceito",
     *  ele sabe que precisa de validações para dar o Reajuste(MAS QUAIS? NÃO SEI E NÃO QUERO SABER
     *  isso é tarefa das classes concretas que implementam esse CONCEITO/INTERFACE DE VALIDAÇÃO )
     *
     * Para continuar avançando vá para a Classe:
     *
     */
}
