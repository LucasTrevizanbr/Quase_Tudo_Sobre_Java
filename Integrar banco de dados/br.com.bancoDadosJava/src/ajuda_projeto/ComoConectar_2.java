package ajuda_projeto;

public class ComoConectar_2 {
    /**
     *                              Connection, DriverManager
     *
     * Para nos conectar a um banco de dados usamos a Classe Connection recebendo um DriverManager.
     * getConnection onde passamos uma URL, um USUÁRIO e uma SENHA(Connection e DriverManager são do pacote
     * SQL). LEMBRANDO QUE PRECISAMOS DO DRIVER DO BANCO E ISSO É UMA LIB EXTERNA, ENTÃO O PROJETO
     * PRECISA TER ELA NAS CONFIGURAÇÕES DE BUILD.
     * Essa "URL" tem que ser passada da seguinte forma: especificação + ":" + SGDB +"://" +
     * local do banco + "/" + nome da base + "?" + configuração de time e server timezone.
     * "jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC" .
     * Toda conexão que a gente abre(na verdade tudo que a gente abre né) precisa ser fechada!!.
     *
     * ==============================================================================================
     *
     * É muito comum que a conexão não seja passada diretamente numa String, geralmente essa conexao
     * fica encapsulada em uma classe que cria a Conexão. E melhorando ainda mais essa conexão pode
     * vir de um arquivo properties.
     *
     *
     */
}
