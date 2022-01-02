package testes;

import dao.CategoriaDAO;
import fabrica.ConexaoFactory;
import modelo.Categoria;
import modelo.Produto;
import dao.ProdutoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestaInsercaoObjeto {
    public static void main(String[] args) {

        try (Connection conexao = new ConexaoFactory().criarConexao()) {

            Produto churrasqueiraEletrica = new Produto("Churrasqueira Elétrica"
                    ,"Ta pegando fogo");

            ProdutoDAO daoProduto = new ProdutoDAO(conexao);
            daoProduto.salvarProduto(churrasqueiraEletrica);

            List<Produto> produtos = daoProduto.listarProdutos();

            produtos.forEach(System.out::println);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}