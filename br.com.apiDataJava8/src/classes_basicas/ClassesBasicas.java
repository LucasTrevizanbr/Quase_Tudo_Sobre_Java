package classes_basicas;

import java.time.*;

public class ClassesBasicas {
    /**nenhuma das classes da API de data do java 8 tem construtor*/
    public static void main(String[] args) {
        /**Instanciamos nossas classes com métodos estáticos*/
        LocalDate data = LocalDate.now();
        System.out.println("Uma data local : " +data);
        /**Se eu quiser instanciar algumas dessas classes a partir de uma data/hora/zona específica,
         * posso usar o método estático de of()*/
        LocalDate aniversario = LocalDate.of(1999, Month.JANUARY, 8);

        LocalTime hora = LocalTime.now();
        System.out.println("Um horário local : "+hora);
        LocalTime horaNascimento = LocalTime.of(11, 20, 00);

        LocalDateTime dataHora = LocalDateTime.now();
        System.out.println("Uma hora e data local: "+ dataHora);
        LocalDateTime dataHoraNascimento = LocalDateTime.of(aniversario, horaNascimento);

        /**No instante podemos perceber que ele me traz uma diferença na hora em relação as outras
         * classes acima, isso acontece pq essa classe representa um instante na linha do tempo e
         * por padrão já usa uma localidade GMT(as outras classes já me trazem um horário do Brasil
         * ,elas são "Local")*/
        Instant instante = Instant.now();
        System.out.println("Um instante no tempo, usando por padrão GMT: "+instante);
        /**Como o Instant está ligado a ideia de millis da linha do tempo, o método of dele mais importate
         * é o ofEpochMilli que recebe millisegundos que representam um instante no tempo*/
        Instant momentoNaLinhaDoTempo = Instant.ofEpochMilli(4800000000000l);
        System.out.println("Um milli aleatório que representa esse momento no tempo: "+momentoNaLinhaDoTempo);

        ZonedDateTime dataHoraComZona = ZonedDateTime.now();
        System.out.println("Uma data e hora com uma zona já armazenada: "+ dataHoraComZona);
        ZonedDateTime zonedHoraDataNasc = ZonedDateTime.of(dataHoraNascimento, ZoneId.of("America/Montevideo"));
        System.out.println("Data e hora de nascimento no fuso do Paraguay: "+zonedHoraDataNasc);

        /**A manipulação de se somar e subtrair dias, semanas, anos e etc.. é EXTREMAMENTE
         * parecido para todas essas classes, elas são IMUTÁVEIS então sempre que alterar
         * deve devolver uma nova instância*/
        System.out.println();
        System.out.println("==================Fazendo operações de data na API===================");
        LocalDate minhaDataLocalDaqui3Dias = data.plusDays(3);
        System.out.println("Data local 3 dias no futuro: "+minhaDataLocalDaqui3Dias);
        LocalTime seteHorasAntesNascimento = horaNascimento.minusHours(7);
        System.out.println("Sete horas antes do nascimento: "+seteHorasAntesNascimento);

    }
}
