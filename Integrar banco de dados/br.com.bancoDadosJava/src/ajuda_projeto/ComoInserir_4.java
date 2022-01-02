package ajuda_projeto;

public class ComoInserir_4 {
    /**
     *
     *                  Statement.RETURN_GENERATED_KEYS, getGeneratedKeys()
     *
     * A inserção também é um Statement, mas do que serve o resultado 'false' da sua execução pra
     * gente quando inserirmos um registro? Depende da sua lógica.
     * Mas aqui a gente pode adicionar no execute() um outro parâmetro ENUM de Statement que é o
     * RETURN_GENERATED_KEYS, esse argumento nos permite RECUPERAR chaves(PK) que foram gerados
     * nesse SQL.
     * E fazemos isso com o método getGeneratedKeys() que retorna um ResultSet que podemos iterar
     * e fazer essa recuperação.
     *
     * Esse conteúdo esta presente em "minio_necessario.TestaInsercao"
     *
     *
     *
     *
     */
}
