package basico_necessario;

import fabricas.FabricaConexao;

import java.sql.*;

public class TestaSelectDinamico {
    public static void main(String[] args) throws SQLException {

        FabricaConexao fabricaConexao = new FabricaConexao();
        Connection conexao = fabricaConexao.criarConexao();

        /**Através da conexão criamos um Statement preparado*/
        PreparedStatement preparedStatement = conexao.prepareStatement("SELECT * FROM produto");

        preparedStatement.execute();
        ResultSet produtos = preparedStatement.getResultSet();

        while(produtos.next()){
            Integer id = produtos.getInt("ID");
            String nome = produtos.getString("NOME");
            String descricao = produtos.getString("DESCRICAO");
            System.out.println(id+", " +nome+", "+descricao);
        }

        conexao.close();
    }
}
