package objetos;

import java.io.Serializable;

public class Produto implements Serializable {

    protected double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Preço: " + this.preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
