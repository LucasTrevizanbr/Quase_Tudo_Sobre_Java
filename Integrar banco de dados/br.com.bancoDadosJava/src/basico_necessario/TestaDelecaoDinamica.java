package basico_necessario;

import fabricas.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaDelecaoDinamica {
    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();
        Connection conexao = fabricaConexao.criarConexao();

        int idMenor = 2;
        int idMaior = 6;

        PreparedStatement preparedStatement = conexao
                .prepareStatement("DELETE FROM PRODUTO WHERE ID > ? AND ID < ?");

        preparedStatement.setInt(1,idMenor);
        preparedStatement.setInt(2,idMaior);
        preparedStatement.execute();

        int linhasModificadas = preparedStatement.getUpdateCount();

        System.out.println(linhasModificadas + " linhas afetadas");
    }
}
