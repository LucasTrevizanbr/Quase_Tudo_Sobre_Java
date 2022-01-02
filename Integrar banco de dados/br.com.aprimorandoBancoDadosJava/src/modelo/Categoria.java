package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Long id;
    private String nome;
    private List<Produto> produtos = new ArrayList<>();

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria: "+this.nome+", id: "+this.id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionar(Produto produto) {
        this.produtos.add(produto);
    }
}
