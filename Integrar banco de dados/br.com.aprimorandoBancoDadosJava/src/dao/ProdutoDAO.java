package dao;

import fabrica.ConexaoFactory;
import modelo.Categoria;
import modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**Classe especializada em interagir com o banco de dados para Entidade de Produto*/
public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvarProduto(Produto produto){
            String comandoSQL = "INSERT INTO PRODUTO(NOME, DESCRICAO) VALUES(?,?)";

            try (PreparedStatement statement = conexao.prepareStatement(comandoSQL,
                    Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, produto.getNome());
                statement.setString(2, produto.getDescricao());

                statement.execute();

                try(ResultSet resultado = statement.getGeneratedKeys()){
                    while(resultado.next()){
                        produto.setId(resultado.getLong(1));
                    }
                }

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
    }

    public void salvarProdutoComCategoria(Produto produto){
        String comandoSQL = "INSERT INTO PRODUTO(NOME, DESCRICAO, CATEGORIA) VALUES(?,?,?)";

        try (PreparedStatement statement = conexao.prepareStatement(comandoSQL,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setLong(3,produto.getCategoriaId());

            statement.execute();

            try(ResultSet resultado = statement.getGeneratedKeys()){
                while(resultado.next()){
                    produto.setId(resultado.getLong(1));
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }



    public List<Produto> listarProdutos(){
        
        List<Produto> listaRetorno = new ArrayList<>();
        
        String comandoSQL = "SELECT * FROM PRODUTO";

        /**Uso a conexão recebida pelo construtor*/
        try (PreparedStatement statement = conexao.prepareStatement(comandoSQL)) {

            statement.execute();

            try(ResultSet resultado = statement.getResultSet()){
                while(resultado.next()){
                    Produto produtoRetornado = new Produto(resultado.getLong(1),
                            resultado.getString(2),resultado.getString("DESCRICAO"));

                    listaRetorno.add(produtoRetornado);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return listaRetorno;
    }

    public List<Produto> buscarPorCategoria(Categoria categoria){
        List<Produto> listaRetorno = new ArrayList<>();

        String comandoSQL = "SELECT * FROM PRODUTO WHERE CATEGORIA_ID = ?";

        try (PreparedStatement statement = conexao.prepareStatement(comandoSQL)) {
            statement.setLong(1,categoria.getId());
            statement.execute();

            try(ResultSet resultado = statement.getResultSet()){
                while(resultado.next()){
                    Produto produtoRetornado = new Produto(resultado.getLong(1),
                            resultado.getString(2),resultado.getString("DESCRICAO"));

                    listaRetorno.add(produtoRetornado);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return listaRetorno;
    }

    public void deletar(Long id){
        try(PreparedStatement statement = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")){
            statement.setLong(1,id);
            statement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao deletar produto: "+exception.getMessage());
        }
    }

    public void alterarProduto (String nome, String descricao, Long id)  {

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append("UPDATE PRODUTO PROD SET ")
                .append("PROD.NOME = ?, ")
                .append("PROD.DESCRICAO = ? ")
                .append(" WHERE ID = ?");

        try(PreparedStatement statement = conexao.prepareStatement(comandoSQL.toString())){
            statement.setString(1,nome);
            statement.setString(2,descricao);
            statement.setLong(3,id);
            statement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro ao alterar produto: "+exception.getMessage());
        }

    }
}
