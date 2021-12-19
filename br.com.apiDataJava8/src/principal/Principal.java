package principal;

public class Principal {
    /**
     * A api de data do Java 8 veio pra resolver ou pelo menos diminuir a complexidade que existia
     * ao se trabalhar com datas em java. Adicionando diversas novas classes e métodos úteis para o
     * desenvolvedor.
     *
     * A manipulação e métodos dessas classes são mto parecidos semanticamente
     * falando, todas essas classes são IMUTÁVEIS, ou seja, após fazer alguma operação deve devolver uma
     * nova instância com a alteração feita.
     *
     * ===================Classes Básicas=============================================================
     * O pacote "classes_basicas.ClassesBasicas" vai nos introduzir as classes mais comuns dessa "nova" API.
     * Nossos métodos de adição de data, subtração e etc PODEM SER ENCADEADOS.
     * ->LocalDate: representa única e EXCLUSIVAMENTE uma DATA(08/01/1999)!
     * ->LocalTime: representa única e EXCLUSIVAMENTE uma HORA(11:20:33.527633900)!
     * ->LocalDateTime: representa uma DATA e HORA(08/01/1999 11:20:33.527633900) NÃO INCLUI FUSO-HORÁRIO!
     * ->Instant: representa um instante/momento na linha do tempo, isso mesmo, um instante na linha
     * do tempo do mundo, armazena em milissegundos a partir de 01/01/1970 00:00:00.(TAMBÉM NÃO INCLUI
     * FUSO).
     * ->ZonedDateTime: essa é a classe mais "completa", ela armazena data, hora e tem time zone
     * (08/01/1999 11:20:33 GMT-3(America/Sao_Paulo) )
     *
     * =====================Calcular Periodo e Duração===============================================
     * A api do java 8 trouxe classes auxiliares que nos ajudam a calcular/armazenar um espaço de
     * tempo entre datas e horas. Podemos calcular periodos entre datas, somar/subtrair com Period e o mesmo
     * para horários com o Duration.
     *
     * ->Period: trabalha com valores baseados em data, dias, meses e anos(DATAS).
     * ->Duration: valores baseados em tempo, hora, minuto, segundos, millis.
     *
     * ======================Formatação e Parse de Data e Hora======================================
     * A api de data do java 8 trouxe apenas uma nova classe para fazer formatação e parse
     * de data e hora.
     *
     * ->DateTimeFormatter: Alguns enuns para trafegar data entre sistemas, alguns enums para apresentar data
     * para o usuário final, e possibilidades de formatação com um pattern próprio.
     */
}
