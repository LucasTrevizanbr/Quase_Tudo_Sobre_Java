package service.reajuste;

import modelos.Tarefa;

import java.math.BigDecimal;
import java.util.List;

/**Essa classe é a nova responsável pelos ajustes de pontos*/
public class ReajusteService {

    /**Agora eu recebo uma lista de validações que são Interfaces, essas Interfaces obrigam minhas
     * classes concretas a implementarem seu método validar*/
    private List<ValidacaoReajuste> validacoes;

    /**Por receber uma lista, eu posso adicionar quantas validações eu quiser e não preciso fazer
     * isso no meu Service. Minhas validações são extendiveis*/
    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    /**Meu serviço de reajuste sabe que tem uma tarefa pra reajustar e quanto querem que aumente os pontos,
     * como serviço eu garanto que minhas regras de reajuste estão sendo cumpridas.*/
    public void reajustarPontosTarefa(Tarefa tarefaASerAjustada, BigDecimal valorAumento){

        this.validacoes.forEach(validacao -> validacao.validar(tarefaASerAjustada, valorAumento));

        /**Se tudo estiver Ok então eu pego os pontos reajustados e falo pra minha tarefa se atualizar,
         * ela não tem noção das regras que eu apliquei aqui.*/
        BigDecimal pontosReajustados = tarefaASerAjustada.getPontosDeConclusao().add(valorAumento);
        tarefaASerAjustada.atualizarPontosConclusao(pontosReajustados);
    }

}
