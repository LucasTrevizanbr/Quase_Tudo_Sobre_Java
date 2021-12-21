package service.reajuste;

import excecoes.ValidacaoException;
import modelos.Tarefa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

/**De maneira concreta cuida da regra de periodicidade sobre Reajuste*/
public class ValidarPeriodicidadeAjuste implements ValidacaoReajuste{

    @Override
    public void validar(Tarefa tarefaASerAjustada, BigDecimal valorAumento){
        LocalDate ultimoReajuste = tarefaASerAjustada.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        Period tempoEntreUltimoReajuste = Period.between(ultimoReajuste, dataAtual);
        if(tempoEntreUltimoReajuste.getMonths() < 6){
            throw new ValidacaoException("A Tarefa precisa completar no mínimo 6 meses " +
                    "desde o ultimo reajuste para ser reajustada!");
        }
    }
}
