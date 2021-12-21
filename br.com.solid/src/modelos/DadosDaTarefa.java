package modelos;

import java.math.BigDecimal;

public class DadosDaTarefa {

    private String nome;
    private String donoDaTarefa;
    private FatorPontoExtra fatorPontoExtra;
    private BigDecimal pontosDeConclusao;

    public DadosDaTarefa(String nome, String donoDaTarefa, FatorPontoExtra fatorPontoExtra,
                         BigDecimal pontosDeConclusao) {
        this.nome = nome;
        this.donoDaTarefa = donoDaTarefa;
        this.fatorPontoExtra = fatorPontoExtra;
        this.pontosDeConclusao = pontosDeConclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDonoDaTarefa() {
        return donoDaTarefa;
    }

    public void setDonoDaTarefa(String donoDaTarefa) {
        this.donoDaTarefa = donoDaTarefa;
    }

    public FatorPontoExtra getFatorPontoExtra() {
        return fatorPontoExtra;
    }

    public void setFatorPontoExtra(FatorPontoExtra fatorPontoExtra) {
        this.fatorPontoExtra = fatorPontoExtra;
    }

    public BigDecimal getPontosDeConclusao() {
        return pontosDeConclusao;
    }

    public void setPontosDeConclusao(BigDecimal pontosDeConclusao) {
        this.pontosDeConclusao = pontosDeConclusao;
    }
}
