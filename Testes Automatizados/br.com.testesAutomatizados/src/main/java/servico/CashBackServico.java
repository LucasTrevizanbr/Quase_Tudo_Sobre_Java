package servico;

import modelo.Cliente;

import java.math.BigDecimal;

public class CashBackServico {

    public void calcularCashback(BigDecimal valorGasto, Cliente cliente){
        BigDecimal valorPorcentagem = new BigDecimal("0.05");
        BigDecimal cashBack = valorGasto.multiply(valorPorcentagem);

        if(cashBack.compareTo(new BigDecimal(700)) > 0){
            cashBack = BigDecimal.ZERO;
        }
        cliente.setCashBack(cashBack);
    }
}
