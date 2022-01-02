package controller;

import dao.CategoriaDAO;
import fabrica.ConexaoFactory;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        Connection conexao = new ConexaoFactory().criarConexao();
        this.categoriaDAO = new CategoriaDAO(conexao);
    }

    public List<Categoria> listar() {
       return this.categoriaDAO.listarCategoria();
    }
}
