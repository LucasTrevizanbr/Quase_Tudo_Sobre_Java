package ajuda_projeto;

public class UsandoDAO_2 {
    /**
     *
     *            DAO - Data Access Object(Padrão de comunicação com "entidades" externas)
     *
     * Java é uma linguagem orientada a objetos, então quando vamos inserir uma informação no
     * banco de dados nós representamos as ENTIDADES com OBJETOS, portanto precisamos usar os
     * atributos desses objetos e não Strings literais.
     *
     * Toda vez que vamos usar um método de banco de dados temos que fazer os inúmeros try with
     * resources para estabelecer uma conexão, criar um statement e recupera o resultado dessa
     * execução, isso gera muito código repetido, então o ideal é isola-lo.
     *
     * Para isolar nossas operações com o banco de dados podemos usar uma Classe que se comunica com
     * o banco de dados para a gente, ela é um intermédio entre nossa aplicação e a base de dados,
     * esse tipo de classe é conhecido como DATA ACCESS OBJECT(Objeto de acesso a base).
     *
     * Dessa maneira TODAS AS MINHAS OPERAÇÕES de base de dados referentes ao meu Produto fica isolada
     * numa classe de acesso ao banco de dados, então sempre que eu quiser alterar, excluir ou
     * criar um Produto eu posso usar minha classe DAO para fazer essas interações com meu banco.
     *
     * Esse código está aqui: "dao.ProdutoDAO"
     *
     */
}
