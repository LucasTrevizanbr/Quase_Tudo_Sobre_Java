package servico;

import modelo.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;

public class CashBackBonusDataServicoTest {

    @Test
    public void deveDarBonusDe6PorCentoSeACompraFoiFeitaEmNovembro(){
        CashBackBonusDataServico servico = new CashBackBonusDataServico();

        BigDecimal valorGasto = new BigDecimal(900);
        LocalDateTime dataCompra = LocalDateTime.of(2022,11,2,
                9,22,20);

        Cliente cliente = new Cliente("Joelton",dataCompra);
        cliente.setHoraDataCompra(dataCompra);

        servico.bonusPorMesBlackFriday(valorGasto, cliente);

        assertEquals(new BigDecimal("54.00"), cliente.getCashBack());
    }


    @Test
    public void deveDarBonusDe10PorCentoSeACompraFoiFeitaEmNovembroDia25(){
        CashBackBonusDataServico servico = new CashBackBonusDataServico();

        BigDecimal valorGasto = new BigDecimal(900);
        LocalDateTime dataCompra = LocalDateTime.of(2022,11,25,
                9,22,20);

        Cliente cliente = new Cliente("Joelton",dataCompra);
        cliente.setHoraDataCompra(dataCompra);

        servico.bonusPorMesBlackFriday(valorGasto, cliente);

        assertEquals(new BigDecimal("90.0"), cliente.getCashBack());
    }

    @Test(expected = Exception.class)
    public void deveLancarUmaExecaoSeACompraNaoFoiFeitaEmNovembro(){
        CashBackBonusDataServico servico = new CashBackBonusDataServico();

        BigDecimal valorGasto = new BigDecimal(900);
        LocalDateTime dataCompra = LocalDateTime.of(2022,10,25,
                9,22,20);

        Cliente cliente = new Cliente("Joelton",dataCompra);
        cliente.setHoraDataCompra(dataCompra);

        servico.bonusPorMesBlackFriday(valorGasto, cliente);
    }
}
