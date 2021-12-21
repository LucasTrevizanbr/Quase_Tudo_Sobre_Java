package modelos;

import java.math.BigDecimal;

public class TarefaParceira {

    private DadosDaTarefa dadosDeTarefa;
    private BigDecimal pontosExtrasDoParceiro;

    public BigDecimal getPontosExtrasDoParceiro() {
        return pontosExtrasDoParceiro;
    }

    public void setPontosExtrasDoParceiro(BigDecimal pontosExtrasDoParceiro) {
        this.pontosExtrasDoParceiro = pontosExtrasDoParceiro;
    }
}
