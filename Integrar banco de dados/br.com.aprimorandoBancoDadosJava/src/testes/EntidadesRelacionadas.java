package testes;

import dao.CategoriaDAO;
import fabrica.ConexaoFactory;
import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadesRelacionadas {
    public static void main(String[] args) {
        List<Categoria> listaCategoria = new ArrayList<>();

        try (Connection conexao = new ConexaoFactory().criarConexao()) {

            CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
            /**Query com o join*/
            listaCategoria = categoriaDAO.listarCategoriaComProdutos();

            /*Query N+1 = RUIM, muitas querys
            listaCategoria.forEach((categoria)->{
                for(Produto produto: new ProdutoDAO(conexao).buscarPorCategoria(categoria)){
                    System.out.println("Categoria: "+categoria.getNome()+", produto: "+produto.getNome());
                }
            });
            */

            /**Iterando sobre apenas uma query e tendo o mesmo resultado*/
            listaCategoria.forEach((categoria)->{
                for(Produto produto: categoria.getProdutos()){
                    System.out.println("Categoria: "+categoria.getNome()+", produto: "+produto.getNome());
                }
            });


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
