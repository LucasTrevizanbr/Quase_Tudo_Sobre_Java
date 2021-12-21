package service.reajuste;

import modelos.Tarefa;

import java.math.BigDecimal;

/**Uma interface padrão para classes concretas que implementam suas regras sobre Reajuste*/
public interface ValidacaoReajuste {

    public void validar(Tarefa tarefaASerReajustada, BigDecimal aumentoDePontos);
}
