package formatacao_parse_data_hora;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class FormatarDataHora {
    public static void main(String[] args) {
        /**A classe de DateTimeFormatter tem alguns enums para formatação, os de padrão
         * ISO. Essas Constantes são na maioria das vezes usadas para transferir datas entre sistemas*/
        DateTimeFormatter formatadorData = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        System.out.println(formatadorData.format(dataHoraAgora));

        /**Para exibir data para um usuário final podemos usar o FormatStyle(alguns formatos prontos).
         * Esse FormatSyle também pode ser aplicado para somente hora ou data e hora, ele tem constantes
         * de "exibição" do tipo curto(short), medium(médio). long(longo) e full(completasso)
         * só funcionam COM ZonedDateTime, porque ele precisa do fuso.*/
        DateTimeFormatter formatadorStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);

        /**Esse formatador depende do Locale(é um ponto a se atentar na hora de exibir as informações)*/
        System.out.println(formatadorStyle.format(dataHoraAgora));

        /**Um outro formatador é com pattern, esse é um dos mais úteis pq vc escolhe a forma com
         * que a hora e data será exibida baseada num pattern passado*/
        DateTimeFormatter formatadorComPatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        /**Um ponto MUITO IMPORTANTE sobre o pattern é que se vc escrever um pattern que mande usar
         * um horário mas estiver passando um LOCALDATE então vai dar exceção. Então presta atenção no que
         * vc ta mandando formatar e o pattern passado.*/
        System.out.println(formatadorComPatter.format(dataHoraAgora));

        /**Se eu quiser transformar uma String em uma data, eu preciso fazer um parse*/
        TemporalAccessor dataParseada = formatadorStyle.parse("23/10/2019");
        LocalDate dataDoParse = LocalDate.from(dataParseada);
        System.out.println(dataDoParse);


    }
}
