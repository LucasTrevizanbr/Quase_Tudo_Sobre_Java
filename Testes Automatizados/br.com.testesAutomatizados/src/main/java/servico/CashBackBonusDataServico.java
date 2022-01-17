package servico;

import modelo.Cliente;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class CashBackBonusDataServico {

    public void bonusPorMesBlackFriday(BigDecimal valorGasto, Cliente cliente){

        LocalDateTime dataHoraCompra = cliente.getHoraDataCompra();

        BigDecimal valorPorcentagem;
        BigDecimal cashBack;

        if(dataHoraCompra.getMonth() != Month.NOVEMBER){
            throw new RuntimeException("Impossível aplicar chashBack de promoção:" +
                    " Compra não foi feita em novembro");

        }else if(dataHoraCompra.getDayOfMonth() == 25){
            valorPorcentagem = new BigDecimal("0.1");
            cashBack = valorGasto.multiply(valorPorcentagem);

            cliente.setCashBack(cashBack);
        }else{
            valorPorcentagem = new BigDecimal("0.06");
            cashBack = valorGasto.multiply(valorPorcentagem);

            cliente.setCashBack(cashBack);
        }
    }
}
