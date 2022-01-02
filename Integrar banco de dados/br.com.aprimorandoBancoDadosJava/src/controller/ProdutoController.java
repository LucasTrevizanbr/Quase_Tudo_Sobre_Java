package controller;

import dao.ProdutoDAO;
import fabrica.ConexaoFactory;
import modelo.Produto;

import java.sql.Connection;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        Connection conexao = new ConexaoFactory().criarConexao();
        this.produtoDAO = new ProdutoDAO(conexao);
    }
    
    public void alterar(String nome, String descricao, Long id) {
        this.produtoDAO.alterarProduto(nome,descricao, id);
    }

    public void deletar(Long id) {
        this.produtoDAO.deletar(id);
    }

    public void salvar(Produto produto) {
        this.produtoDAO.salvarProduto(produto);
    }

    public List<Produto> listar() {
        return this.produtoDAO.listarProdutos();
    }
}
