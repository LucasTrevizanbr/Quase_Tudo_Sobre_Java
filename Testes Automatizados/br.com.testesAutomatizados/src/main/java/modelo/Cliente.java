package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cliente {

    private String nome;
    private LocalDateTime horaDataCompra;
    private BigDecimal cashBack;

    public Cliente(String nome, LocalDateTime horaDaCompra) {
        this.nome = nome;
        this.horaDataCompra = horaDaCompra;
    }

    public LocalDateTime getHoraDataCompra() {
        return horaDataCompra;
    }

    public BigDecimal getCashBack() {
        return cashBack;
    }

    public void setCashBack(BigDecimal cashBack) {
        this.cashBack = cashBack;
    }

    public void setHoraDataCompra(LocalDateTime horaDataCompra) {
        this.horaDataCompra = horaDataCompra;
    }
}
