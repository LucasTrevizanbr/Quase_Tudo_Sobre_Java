package ajuda_projeto;

public class PoolDataSource_1 {

    /**
     *                                           Cenário
     *
     * Da maneira que fizemos na parte 1 desse programa usamos uma única conexão para fazer as
     * operações de CRUD da nossa aplicação com o banco de dados. O que aconteceria se eu tivesse
     * várias requisições para usar o banco de dados a partir de uma mesma conexão?
     * As requisições seriam ENFILEIRADAS, não faz sentido as conexões terem que esperar cada uma
     * terminar para que possam ser executadas. O que faria sentido é ABRIR UMA OUTRA CONEXÃO
     * junto com a conexão que já esta em execução, beleza, com isso eu posso processar várias requisições
     * sem que uma tenha que esperar a outra. Mas e se eu tivesse MILHÕES DE REQUISIÇÕES SIMULTÂNEAS?
     * Daria ruim, meu banco de dados não aguentaria tanta pressão, nenhum banco aguentaria!!
     *
     * O que podemos fazer nesse caso é LIMITAR A QUANTIDADE DE CONEXÕES QUE NOSSA APLICAÇÃO VAI TER,
     * se eu sei o quanto meu banco aguenta de requisição simultânea eu posso limitar minhas conexões
     * baseadas nessa informação, GARANTINDO QUE EU TENHA O MÁXIMO POSSÍVEL DE CONEXÕES MAS SEM ESTRAPOLAR
     * O BANCO e é pra isso que serve o POOL DE CONEXÕES.
     *
     * ================================Pool de Conexões, DataSource=====================================
     * Os pools de conexões também são DRIVERS, e assim como os SGDB's existem vários deles. Aqui eu vou
     * usar o C3P0(específico para MySQL). Se um pool de conexão é um DRIVER e eu to usando o C3P0,
     * o que aconteceria se por acaso eu quisesse mudar meu driver de pool no futuro?
     *
     * Como o JDBC é uma Interface para meu Driver de banco, eu também tenho uma Interface para o meu
     * Driver de pool de conexão, essa interface se chama DataSource.
     *
     * Essa implementação ta aqui: "fabrica.ConexaoFactory".
     *
     *
     *
     */
}
