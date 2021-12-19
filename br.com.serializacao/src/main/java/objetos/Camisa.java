package objetos;

public class Camisa  extends Produto{

    private String marca;
    private String modelo;


    public Camisa (String marca, String modelo, double preco) {
        super(preco);
        this.marca = marca;
        this.modelo = modelo;

    }

    @Override
    public String toString() {
        return "Camisa{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                '}';
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
