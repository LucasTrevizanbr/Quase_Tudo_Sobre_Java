package service.adicionar_pontos;

import excecoes.ValidacaoException;
import modelos.FatorPontoExtra;
import modelos.Tarefa;

import java.math.BigDecimal;

public class PontoExtraService {

    public void adicionarPontoExtra(Tarefa tarefaAGanharPontoExtra, boolean concluida){
        if(!concluida) {
            throw new ValidacaoException("Essa tarefa não esta concluida, portanto não recebe" +
                    " pontos extras!");
        }

        BigDecimal pontoExtra = new BigDecimal(0);
        if(FatorPontoExtra.FACIL == tarefaAGanharPontoExtra.getDadosDaTarefa().getFatorPontoExtra()){
            pontoExtra.add(new BigDecimal(0.1));

        }else if(FatorPontoExtra.MEDIO == tarefaAGanharPontoExtra.getDadosDaTarefa().getFatorPontoExtra()){
            pontoExtra.add(new BigDecimal(0.2));

        }else if(FatorPontoExtra.DIFICIL == tarefaAGanharPontoExtra.getDadosDaTarefa().getFatorPontoExtra()){
            pontoExtra.add(new BigDecimal(0.5));
        }else{
            pontoExtra.add(new BigDecimal(1));
        }

        tarefaAGanharPontoExtra.adicionarPontoExtra(pontoExtra);
    }

}
