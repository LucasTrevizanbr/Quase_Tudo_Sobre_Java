package regular_necessario;

import fabricas.FabricaConexao;
import modelos.Produto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestaCommitRollback {
    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();
        /**try with resources, vai fechar a conexão automaticamente*/
        try(Connection conexao = fabricaConexao.criarConexao()) {
            /**Com isso eu digo pra minha conexão que a responsabilidade do commit é minha*/
            conexao.setAutoCommit(false);

            List<Produto> produtos = new ArrayList<>();
            produtos = criarProdutos(produtos);

            /**Insiro meus produtos*/
            inserirProdutos(conexao, produtos);

            /**Se tudo der certo eu faço o commit, garantindo a atomicidade da operação*/
            conexao.commit();
        }
    }

    private static void inserirProdutos(Connection conexao, List<Produto> produtos) throws SQLException {

        produtos.forEach((produto) -> {
            /**Esse recurso é o Try with resources, ele permite que não explicitemos o fechamento da
             * conexão, apenas de passar o que deve ser fechado depois de usado no try() ele
             * fecha automaticamente*/
            try ( PreparedStatement preparedStatement = conexao.prepareStatement
                    ("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)",
                            Statement.RETURN_GENERATED_KEYS)){

                preparedStatement.setString(1, produto.getNome());
                preparedStatement.setString(2, produto.getDescricao());

                preparedStatement.execute();

                /**Outro try with resources*/
                try(ResultSet chavesGeradas = preparedStatement.getGeneratedKeys()){
                    while (chavesGeradas.next()) {
                        Integer idGerado = chavesGeradas.getInt(1);
                        System.out.println("id gerado : " + idGerado);
                    }
                };

            } catch (SQLException e) {
                try {
                    /**Se algum deles der errado, pode dar rollback ai*/
                    conexao.rollback();
                } catch (SQLException exception) {
                    throw new RuntimeException("Erro no rollback" + exception.getMessage());
                }
                throw new RuntimeException("Erro na inserção: " + e.getMessage());
            }
        });
    }


    public static List<Produto> criarProdutos(List<Produto> lista){
        lista.add(new Produto("Carrinho de Rolemã","TecToy",new BigDecimal("60.30")));
        lista.add(new Produto("Airfryer","Polishop",new BigDecimal("310.50")));

        return lista;
    }
}
