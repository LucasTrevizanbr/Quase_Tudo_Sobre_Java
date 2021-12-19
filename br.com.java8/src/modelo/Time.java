package modelo;

import java.util.ArrayList;
import java.util.List;

public class Time {

    private String nomeClube;
    private String modalidade;
    private int numeroJogadores;

    public Time(String nomeClube, String modalidade, int numeroJogadores) {
        this.nomeClube = nomeClube;
        this.modalidade = modalidade;
        this.numeroJogadores = numeroJogadores;
    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public static List<Time> devolveTimes(){

        List<Time> listaTimes = new ArrayList<>();
        listaTimes.add(new Time("Corinthians","Futebol",22));
        listaTimes.add(new Time("Gremio","Futebol",22));
        listaTimes.add(new Time("Pinheiros","Volei", 12));
        listaTimes.add(new Time("Vasco","Futebol", 23));
        listaTimes.add(new Time("Pain Games","e-sports",8));
        listaTimes.add(new Time("Lakers","Basquete",13));
        listaTimes.add(new Time("Osasco","Volei",12));

        return listaTimes;

    }

}
