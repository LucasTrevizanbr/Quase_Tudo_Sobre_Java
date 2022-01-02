package ajuda_projeto;

public class NecessidadeConexao_1 {
    /**
     *                                 Cenário
     *
     * Uma aplicação Java não consegue se integrar ativamente com um banco de dados. Nossa aplicação
     * roda Java e nosso banco de dados tem seu protocolo próprio.
     * Pensando nessa diferença os devs do MySQL criaram uma BIBLIOTECA(conjunto de Classes e
     * Interfaces) que facilita nossa conexão, esse tipo de biblioteca é conhecida como DRIVER.
     * Esse Driver é um meio de campo entre nossa aplicação e o banco de dados, eu falei do MySQL mas
     * todos os outros bancos também possuem seus Drivers para que possamos fazer a conexão.
     * Ainda assim com todos esses SGDB's disponibilizando Drivers para a gente, teriamos mto trabalho
     * em fazer a troca de banco da aplicação toda vez que quisessemos, pensando nisso o JAVA criou
     * outra camada entre a APLICAÇÃO e o DRIVER, essa camada é a JDBC.
     * Esse JDBC(java database connective) vai ser a abstração que vai ditar os métodos que os DRIVERS
     * dos SGDB's precisam implementar, então a JDBC é um conjunto de Interfaces que possibilita
     * abster da configuração desses DRIVERS. Os Drivers vão assinar o contrato do JDBC e vão ter
     * todas as implementações de métodos que nossa aplicação precisa para utilizar algum SGDB, dessa
     * maneira Á NÍVEL DE CONECTIVIDADE não precisamos nos preocupar com configurações de banco.
     *
     *
     *
     *
     */
}
