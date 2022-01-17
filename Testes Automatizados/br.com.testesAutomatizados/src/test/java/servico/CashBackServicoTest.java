package servico;

import modelo.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class CashBackServicoTest {

    @Test
    public void cashBackDeveSerZeroSeValorForSuperiorALimite(){
        /**Cenário*/
        CashBackServico servico = new CashBackServico();

        BigDecimal valorGasto = new BigDecimal(15000);
        Cliente cliente = new Cliente("Lorival", LocalDateTime.now());

        /**Execução do método alvo*/
        servico.calcularCashback(valorGasto, cliente);

        /**Assertiva, primeiro parâmetro é o que eu espero e o segundo é o que eu tenho atualmente*/
        assertEquals(BigDecimal.ZERO, cliente.getCashBack());
    }

    @Test
    public void cashBackDeveSerCoerenteComAPorcentagemEstimada(){
        CashBackServico  servico = new CashBackServico();

        BigDecimal valorGasto = new BigDecimal(7000);
        Cliente cliente = new Cliente("Lorival", LocalDateTime.now());

        servico.calcularCashback(valorGasto, cliente);

        assertEquals(new BigDecimal("350.00"), cliente.getCashBack());
    }


    @Test
    public void cashBackDeveSerCoerenteComAPorcentagemEstimadaUsandoValorLimite(){
        CashBackServico  servico = new CashBackServico();

        BigDecimal valorGasto = new BigDecimal(14000);
        Cliente cliente = new Cliente("Lorival", LocalDateTime.now());

        servico.calcularCashback(valorGasto, cliente);

        assertEquals(new BigDecimal("700.00"), cliente.getCashBack());
    }

}
