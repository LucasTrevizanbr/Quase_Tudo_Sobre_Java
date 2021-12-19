package calcular_periodo_duracao;

import java.time.LocalDate;
import java.time.Period;

public class Periodo {
    public static void main(String[] args) {
        /**Podemos passar um periodo completo*/
        Period periodo = Period.of(1,6,3);
        System.out.println("Um periodo de um ano, seis meses e tres dias: "+periodo);
        /**Ou periodos parcias, como apenas o periodo de dias, ou de meses ou de anos*/
        Period.ofDays(3);
        Period.ofMonths(1);
        Period periodo3Anos = Period.ofYears(3);

        /**Podemos usar o Period para saber o tempo entre uma Date e outra*/
        LocalDate dataAtual = LocalDate.now();
        LocalDate nascimento = LocalDate.of(1999,1,8);
        Period periodoEntreNascimentoEHoje = Period.between(dataAtual, nascimento);
        System.out.println("Periodo entre meu nascimento e hoje: "+periodoEntreNascimentoEHoje);
        /**podemos também fazer operações em cima desse periodo*/
        Period periodoMaisDias = periodoEntreNascimentoEHoje.plusDays(2);
        System.out.println("Não ta com comportamento esperado: "+periodoMaisDias);

        /**Podemos somar/subtrair um PERIODO de uma Date*/
        LocalDate dataAtualMaisTresAnos = dataAtual.plus(periodo3Anos);
        System.out.println("Data atual mais um periodo de 3 anos: "+dataAtualMaisTresAnos);
    }
}
