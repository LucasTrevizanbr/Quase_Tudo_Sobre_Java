package calcular_periodo_duracao;

import java.time.Duration;
import java.time.LocalTime;

public class Duracao {
    public static void main(String[] args) {
        /**A Duration é semelhando a Period, porém com horas, a duração de segundos e nanosegundos
         * ficam no mesmo campo*/
        Duration duracaoUmDia = Duration.ofDays(1);
        Duration duracaoUmaHora = Duration.ofHours(1);
        Duration duracao450Minutos = Duration.ofMinutes(450);
        Duration duracaoSegundoNanosegundo = Duration.ofSeconds(10,500);
        System.out.println("Duração de um dia: "+duracaoUmDia );
        System.out.println("Duração uma hora: "+duracaoUmaHora);
        System.out.println("Duração de 450 minutos: "+duracao450Minutos);
        System.out.println("Duração 10 segundos e 500 nanossegundos: "+ duracaoSegundoNanosegundo);

        /**Podemos usar o between para saber o tempo entre um horário e outro*/
        LocalTime horaUm = LocalTime.of(11,12,30);
        LocalTime horaDois = LocalTime.of(11,13,46);
        Duration tempoEntreHoras = Duration.between(horaUm, horaDois);
        System.out.println("Tempo entre horaUm e horaDois: "+tempoEntreHoras);

        /**Também podemos adicionar e subtrair nossas Durações*/
    }
}
