package modelo;

import java.util.Objects;

public class Pais {

    private String nome;
    private int populacao;

    public Pais(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    /*O método que me diz o que eu considero igual entre meus objetos*/
    @Override
    public boolean equals(Object obj) {
        Pais pais = (Pais) obj;
        return this.nome.equals(((Pais) obj).nome);
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    /*O método que gera meu hasch baseado no meu atributo */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return this.nome + " - População: " +this.populacao;
    }
}
