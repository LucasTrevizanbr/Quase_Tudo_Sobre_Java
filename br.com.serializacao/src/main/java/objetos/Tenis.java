package objetos;

import java.io.Serializable;

/**
 * A interface de Serializable não possue nenhum método, ela apenas é uma interface de marcação
 */
public class Tenis extends Produto {

    /*Esse atributo de serial version é gerado de forma automatica pela jvm se não for explicitamente
    declarado, isso pode gerar erro de serial incompatível
    Basicamente é um atributo para administrar a versão da classe.
    */
    private static final long serialversionUID = 1l;

    private String marca;
    private String modelo;

    public Tenis(String marca, String modelo, double preco) {
        super(preco);
        this.marca = marca;
        this.modelo = modelo;

    }

    @Override
    public String toString() {
        return "Modelo: "+this.modelo +", Marca: " + this.marca +", Preço: " + super.preco;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

