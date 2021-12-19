package app;

import modelo.Nacao;
import modelo.Soldado;

import java.util.ArrayList;
import java.util.List;

/**
 * Trabalhar com listas de objetos que estão relacionados a outro objeto,
 * por exemplo , os nossos soldados defendem nações diferentes, portanto
 * uma nação tem muitos soldados oneTomany -> manyToOne.
 *
 * Uma nota importante é o comportamento dos métodos toString(). minha Nacao vai chamar seu toString()
 * e meu Soldado vai chamar seu próprio toString().
 */
public class PrincipalListaClasseRelacionada {
    public static void main(String[] args) {
        Nacao nacao = new Nacao("Empério Mong", 3);
        nacao.setSoldadosDaNacao(gerarSoldados());

    }

    public static List<Soldado> gerarSoldados(){
        Soldado soldadoUm = new Soldado(100, 15, "Guerreiro");
        Soldado soldadoDois = new Soldado(65, 30, "Arqueiro");
        Soldado soldadoTres = new Soldado(120, 8, "Escudeiro");

        List<Soldado> listaDeSoldados = new ArrayList<>();
        listaDeSoldados.add(soldadoUm);
        listaDeSoldados.add(soldadoDois);
        listaDeSoldados.add(soldadoTres);

        return listaDeSoldados;
    }
}
