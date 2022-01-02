package basico_necessario;

import fabricas.FabricaConexao;

import java.sql.*;

public class TestaInsercaoDinamica {
    public static void main(String[] args) throws SQLException {

        FabricaConexao fabricaConexao = new FabricaConexao();
        Connection conexao = fabricaConexao.criarConexao();

        /**tenho meus atributos previamente capturados*/
        String nomeProduto = "Bracelete smartch";
        String descricaoProduto = "Xiaomi";

        /**Preparo meu comando usando "?" onde vou inserir meu dado*/
        PreparedStatement preparedStatement = conexao
                .prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)",
                        Statement.RETURN_GENERATED_KEYS);

        /**Falo pro meu objeto o indice da substituição e o valor que ele irá ter*/
        preparedStatement.setString(1,nomeProduto);
        preparedStatement.setString(2,descricaoProduto);

        /**Executo o sql e não preciso passar um parâmetro para recuperar minhas keys geradas*/
        preparedStatement.execute();
        ResultSet chavesGeradas = preparedStatement.getGeneratedKeys();

        while(chavesGeradas.next()){
            Integer idGerado = chavesGeradas.getInt(1);
            System.out.println("id gerado : "+idGerado);
        }
    }
}
