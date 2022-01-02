package testes;

import fabrica.ConexaoFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestarSelect {
    public static void main(String[] args) throws SQLException {
        ConexaoFactory fabricaConexao = new ConexaoFactory();
        Connection conexao = fabricaConexao.criarConexao();

        /**Através da conexão criamos um Statement*/
        Statement statement = conexao.createStatement();

        /**O execute contém o SQL mas seu retorno é um boolean, onde quando lista é o retorno
         * então o resultado é true*/
        boolean resultado = statement.execute("SELECT * FROM produto");

        /**Usamos o ResultSet para armazenar os dados retornados*/
        ResultSet produtos = statement.getResultSet();

        /**Iteramos sobre eles e podemos pegar seus atributos*/
        while(produtos.next()){
            Integer id = produtos.getInt("ID");
            String nome = produtos.getString("NOME");
            String descricao = produtos.getString("DESCRICAO");
            System.out.println(id+", " +nome+", "+descricao);
        }

        conexao.close();
    }
}
