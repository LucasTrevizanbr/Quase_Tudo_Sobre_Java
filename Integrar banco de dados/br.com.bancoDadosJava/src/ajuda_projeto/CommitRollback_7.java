package ajuda_projeto;

public class CommitRollback_7 {
    /**
     *                         Connection.commit(), .rollback(), Try with resources
     *
     * Imaginando que a gente tem que inserir uma lista de produtos invés de um só podemos pensar
     * que talvez ocorra um erro durante essa inserção. Se der erro em um produto nessa série de
     * transações, eu vou ter todos os anteriores inseridos mas esse produto que deu erro não e os
     * sequenciais depois dele também não.
     * Pra contornar esse problema nós podemos PEGAR O CONTROLE DA TRANSAÇÃO, fazemos isso dizendo
     * pra nossa Connection que o autoCommit dela é false( conexao.setAutoCommit(false) ).
     * A principal ideia em ter o controle da transação é manter a atomicidade da operação com o banco,
     * onde eu posso ou fazer tudo ou não fazer nada, dessa maneira garantindo alguma integridade
     * importante no meu sistema.
     * Da mesma maneira também posso explicitar o rollback no meu catch.
     *
     * Esses exemplos estão aqui:"regular_necessario.TestaCommitRollback"
     *
     */
}
