package minimo_necessario;

import fabricas.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaDelecao {
    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();
        Connection conexao = fabricaConexao.criarConexao();

        Statement statement = conexao.createStatement();

        statement.execute("DELETE FROM PRODUTO WHERE ID > 2 AND ID < 6");

        int linhasModificadas = statement.getUpdateCount();

        System.out.println(linhasModificadas + " linhas afetadas");
    }
}
