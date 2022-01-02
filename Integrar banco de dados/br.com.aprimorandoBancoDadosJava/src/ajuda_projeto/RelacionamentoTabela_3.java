package ajuda_projeto;

public class RelacionamentoTabela_3 {

    /**
     *                                  Usando join eficientemente
     *
     * Dificilmente uma entidade não estará relacionada a outra, agora nosso Produto vai ser
     * relacionado a uma tabela de Categoria. Uma solução que podemos adotar é fazer for aninhados
     * para combinar buscar, por exemplo: buscar minhas categorias, depois iterar sobre o retorno de
     * uma consulta do DAO de produto utilizando um método de buscar por categoria passando as
     * categorias encontradas. Isso parece não ser mto eficiente, eu to usando duas querys aninhadas
     * o que parece estranho e com potencial de ficar altamente verboso.
     * Além de que PARA CADA CATEGORIA RETORNADA EU FAÇO OUTRA QUERY, isso não é performatico e
     * é uma PÉSSIMA PRÁTICA, isso se chama "query N+1"!!!
     *
     * Então qual a prática certa ao se trabalhar com entidades relacionadas? Podemos usar um
     * um INNER JOIN ou clausulas mais específicas. Desse modo conseguimos trazer o resultado
     * esperado, podemos então no DAO fazer uma lógica que vincule os campos buscados ao objeto
     * que estamos representando.
     *
     * A query com Inner join ta aqui: "dao.ProdutoDAO"
     *
     *
     */
}
