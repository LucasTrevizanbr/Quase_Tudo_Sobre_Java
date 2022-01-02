package ajuda_projeto;

public class SqlDinamicos_6 {
    /**
     *                                        PreparedStatement
     *
     * Óbvio que uma inserção chumbada é praticamente impossível de ser usada. Quando precisamos inserir
     * um registro no banco de dados ele precisa vir de uma operação, seja de uma tela do usuário,
     * seja de UM OBJETO QUE FOI PROCESSADO, não importa. Esses atributos tem que vir de maneira dinâmica.
     * Considerando isso então podemos supor que corre algum risco desses atributos que recebemos de
     * uma maneira dinâmica conter algum erro e podendo estourar alguma exceção, para remediar isso
     * podemos usar o PreparedStatement.
     * Com o prepareStatement eu posso deixar a cargo do JDBC conferir pra mim se as informações de
     * inserção estão vindo com alguma sintaxe inesperada que possa lançar uma exceção(um erro de
     * digitação ou coisa do tipo).
     * Usando o prepareStatemen() eu retorno um Objeto PreparedStatement onde eu seto os atributos
     * que eu quero usar na minha query substituindo as "?", passando o index da "?" e o valor.
     * Então minha primeira "?" é o indice 1, e assim sucessivamente.
     * Com isso eu posso recuperar minhas Keys geradas sem parametros no execute(), além de ter um código
     * mais limpo e mais previamente tratado com um statemente preparado.
     *
     * O mesmo pode ser feito para as outras operação que estão aqui : "basico_necessario".
     */
}
