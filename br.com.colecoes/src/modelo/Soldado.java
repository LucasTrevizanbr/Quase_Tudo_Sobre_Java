package modelo;

public class Soldado {

    private int pontosDeVida;
    private int pontosDeAtaque;
    private String classe;

    public Soldado(int pontosDeVida, int pontosDeAtaque, String classe) {
        this.pontosDeVida = pontosDeVida;
        this.pontosDeAtaque = pontosDeAtaque;
        this.classe = classe;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosDeAtaque() {
        return pontosDeAtaque;
    }

    public void setPontosDeAtaque(int pontosDeAtaque) {
        this.pontosDeAtaque = pontosDeAtaque;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    /**
     * Método herdado de object
     * @return
     */
    @Override
    public String toString() {
        return "\nSoldado classe: " +this.classe + "\tPontos de vida: "+this.pontosDeVida+"\tPontos de ataque: "
                +this.pontosDeAtaque +"\n-----------------------------//--------------------------//---------------";
    }
}
