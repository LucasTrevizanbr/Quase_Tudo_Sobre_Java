package dao;

import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {


    private Connection conexao;

    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Categoria> listarCategoria(){

        List<Categoria> listaRetorno = new ArrayList<>();

        String comandoSQL = "SELECT * FROM CATEGORIA";

        /**Uso a conexão recebida pelo construtor*/
        try (PreparedStatement statement = conexao.prepareStatement(comandoSQL)) {

            statement.execute();

            try(ResultSet resultado = statement.getResultSet()){
                while(resultado.next()){
                    Categoria categoriaRetornada = new Categoria(resultado.getLong(1),
                            resultado.getString(2));

                    listaRetorno.add(categoriaRetornada);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return listaRetorno;
    }

    /**Usando join*/
    public List<Categoria> listarCategoriaComProdutos(){

        List<Categoria> listaRetorno = new ArrayList<>();
        Categoria ultimaCategoria = null;
        StringBuilder comandoSQL = new StringBuilder();

        comandoSQL.append("SELECT * FROM CATEGORIA CAT ")
                .append("INNER JOIN PRODUTO PROD ")
                .append("ON CAT.ID = PROD.CATEGORIA_ID");

        try (PreparedStatement statement = conexao.prepareStatement(comandoSQL.toString())) {

            statement.execute();

            try(ResultSet resultado = statement.getResultSet()){
                while(resultado.next()){

                    /**Garanto que só vou instanciar uma categoria quando ela for diferente*/
                    if(ultimaCategoria == null || !ultimaCategoria.getNome()
                            .equals(resultado.getString(2))){

                        Categoria categoriaRetornada = new Categoria(resultado.getLong(1),
                                resultado.getString(2));

                        ultimaCategoria = categoriaRetornada;

                        listaRetorno.add(categoriaRetornada);
                    }

                    /**Vinculo o produto a categoria*/
                    Produto produto = new Produto(resultado.getLong(3),resultado.getString(4),
                            resultado.getString(5));
                    ultimaCategoria.adicionar(produto);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return listaRetorno;
    }
}
