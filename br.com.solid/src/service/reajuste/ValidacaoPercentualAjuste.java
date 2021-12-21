package service.reajuste;

import excecoes.ValidacaoException;
import modelos.Tarefa;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**De maneira concreta cuida da regra de reajuste percentual*/
public class ValidacaoPercentualAjuste implements ValidacaoReajuste {

    @Override
    public void validar(Tarefa tarefaASerAjustada, BigDecimal valorAumento){

        BigDecimal pontosAtuaisTarefa = tarefaASerAjustada.getPontosDeConclusao();

        BigDecimal percentualReajuste = valorAumento.divide(pontosAtuaisTarefa, RoundingMode.HALF_UP);

        /**Se você quiser aumentar mais que 40% então vai dar ruim*/
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% dos pontos");
        }

    }
}
