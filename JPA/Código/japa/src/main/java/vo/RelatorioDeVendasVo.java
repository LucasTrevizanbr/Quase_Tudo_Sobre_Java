package vo;

import java.time.LocalDateTime;

public class RelatorioDeVendasVo {

    private String nome;
    private Long quantidade;
    private LocalDateTime ultimaVenda;

    public RelatorioDeVendasVo(String nome, Long quantidade, LocalDateTime ultimaVenda) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.ultimaVenda = ultimaVenda;
    }

    public String getNome() {
        return nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getUltimaVenda() {
        return ultimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo{" +
                "nome do produto = '" + nome + '\'' +
                ", quantidade vendida = " + quantidade +
                ", ultima Venda = " + ultimaVenda.toLocalDate() +
                '}';
    }
}
