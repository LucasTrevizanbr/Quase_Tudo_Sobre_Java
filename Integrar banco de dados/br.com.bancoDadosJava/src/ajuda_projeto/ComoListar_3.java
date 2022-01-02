package ajuda_projeto;

public class ComoListar_3 {
    /***
     *
     *                              Statement, ResultSet, execute()
     *
     * Como uma conexão em mão podemos fazer interações com o banco de dados. Essas interações em java
     * são conhecidas como Statement. Pra isso então criamos a partir da Connection um objeto de Statement,
     * esse objeto então possue o método execute onde podemos passar um COMANDO SQL.
     *
     * A particularidade desse método de "execute" é o retorno dele que é do tipo "boolean", onde se meu
     * retorno é uma lista ele me devolve um true, se por acaso MINHA OPERAÇÃO NÃO FOR ME DEVOLVER UMA
     * LISTA (UPDATE, DELETE) ele me retorna falso.
     *
     * Beleza, se o statement é um boolean como eu pego minha lista? USAMOS O MÉTODO getResultSet(),
     * esse getResultSet precisa ser iterado e a partir dessa iteração ter seus atributos recuperados,
     * por sorte já temos o next() nesse resultSet, com isso podemos usar os métodos que RECUPERAM O
     * ATRIBUTO PELO TIPO onde passamos o índice ou o nome da coluna. Algo como: itera sobre meu
     * resultado e me pega desse elemento o atributo ID que é do tipo Integer, esse nome que é do tipo String.
     *
     * Esse conteúdo esta presente em "minio_necessario.TestaSelect"
     * ====================================================================================================
     *
     */
}
