package minimo_necessario;

import fabricas.FabricaConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        FabricaConexao fabricaConexao = new FabricaConexao();
        Connection conexao = fabricaConexao.criarConexao();

        Statement statement = conexao.createStatement();

        /**Um insert não é uma lista, portanto o resultado esperado é false, no execute eu posso passar
         * um segundo parâmetro que me Permite recuperar a chave primária gerada*/
        boolean resultado = statement
                .execute("INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES ('Caminhote','Mercedes Benz')"
                , Statement.RETURN_GENERATED_KEYS);

        ResultSet resultadoInsercao = statement.getGeneratedKeys();

        /**Aqui só funciona com Index no parametro, uma tabela sempre começa pelo Index 1*/
        while(resultadoInsercao.next()){
            Integer idGerado = resultadoInsercao.getInt(1);
            System.out.println(idGerado);
        }

        System.out.println(resultado);

        conexao.close();



    }
}
