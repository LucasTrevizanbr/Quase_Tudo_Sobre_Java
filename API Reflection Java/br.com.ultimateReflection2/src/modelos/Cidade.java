package modelos;

import anotacoes.NomeTagXml;

import java.util.Objects;

@NomeTagXml("cidade")
public class Cidade {

    String nome;
    String UF;

    @NomeTagXml("populacao")
    String qtdHabitantes;

    public Cidade() {

    }

    public Cidade(String nome, String UF, String qtdHabitantes) {
        this.nome = nome;
        this.UF = UF;
        this.qtdHabitantes = qtdHabitantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getQtdHabitantes() {
        return qtdHabitantes;
    }

    public void setQtdHabitantes(String qtdHabitantes) {
        this.qtdHabitantes = qtdHabitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return nome.equals(cidade.nome) && UF.equals(cidade.UF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, UF);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", UF='" + UF + '\'' +
                ", qtdHabitantes='" + qtdHabitantes + '\'' +
                '}';
    }
}
