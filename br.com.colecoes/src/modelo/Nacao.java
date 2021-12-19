package modelo;

import java.util.List;
import java.util.Set;

/**
 * Importante quando relacionamos uma classe a outra precisamos manter o tipo mais genérico
 * por exemplo usar a interface List invés de uma implementação mais específica,
 * isso nos permite ter mais flexibilidade ao implementar classes de listas mais especificas
 * para diferentes objetivos.
 */
public class Nacao {

    private String nomeNacao;
    private int bonus;
    List<Soldado> soldadosDaNacao;
    Set<Pais> paisesConquistados;

    public Nacao(String nomeNacao, int bonus){
        this.nomeNacao = nomeNacao;
        this.bonus = bonus;
    }

    public Nacao(String nacao, int bonus, List<Soldado> soldadosDaNacao) {
        this.nomeNacao = nacao;
        this.bonus = bonus;
        this.soldadosDaNacao = soldadosDaNacao;
    }

    public String getNacao() {
        return nomeNacao;
    }

    public void setNacao(String nacao) {
        this.nomeNacao = nacao;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public List<Soldado> getSoldadosDaNacao() {
        return soldadosDaNacao;
    }

    public int quantidadeDeSoldadosDaNacao(){
        return this.soldadosDaNacao.size();
    }

    public void setSoldadosDaNacao(List<Soldado> soldadosDaNacao) {
        this.soldadosDaNacao = soldadosDaNacao;
    }


    @Override
    public String toString() {
        return "Nação: "+ this.nomeNacao +"\t| Bonus de status:"+this.bonus +"\t| Soldados disponíveis: "
                +this.quantidadeDeSoldadosDaNacao();
    }

    public String getNomeNacao() {
        return nomeNacao;
    }

    public void setNomeNacao(String nomeNacao) {
        this.nomeNacao = nomeNacao;
    }

    public Set<Pais> getPaisesConquistados() {
        return paisesConquistados;
    }

    public void setPaisesConquistados(Set<Pais> paisesConquistados) {
        this.paisesConquistados = paisesConquistados;
    }
}
