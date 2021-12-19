package app;

import modelo.Nacao;
import modelo.Pais;

import java.util.*;

/**
 * Se eu quisesse apenas procurar um pais que tem uma certa quantidade de habitantes eu não precisaria
 * percorrer uma coleção, eu posso simplesmente usar um mapa.
 *
 * Um ponto muito importante sobre Map é que ele busca um VALOR por CHAVE, você não pode fazer algo
 * como(ou não deveria) tentar buscar uma lista de paises que tenham mais que x quantidade de habitantes,
 * nesse caso é recomendável ir por outro caminho. Se você atribui valor a uma chave que já existe no mapa
 * então esse valor é sobrescrito(não mantém ambos)
 */
public class PrincipalMapa {

    public static void main(String[] args) {
        Nacao nacao = new Nacao("Empério Shiaq",2);
        nacao.setPaisesConquistados(gerarPaises());
        System.out.println(nacao.getPaisesConquistados());

        Map<Integer, Pais> paisesMapeados = mapearPaises(nacao.getPaisesConquistados());
        Pais paisCom600MilHabitantes =  paisesMapeados.get(100000);
        System.out.println(paisCom600MilHabitantes);


    }

    public static Map<Integer, Pais> mapearPaises(Set<Pais> paisesConquistados){
        Map<Integer, Pais> paisesMapeadosPorHabitantes = new HashMap<>();
        for (Pais pais : paisesConquistados){
            paisesMapeadosPorHabitantes.put(pais.getPopulacao(), pais);
        }

        return paisesMapeadosPorHabitantes;
    }

    public static Set<Pais> gerarPaises(){
        Set<Pais> paises = new HashSet<>();
        paises.add(new Pais("OrderGold",667000));
        paises.add(new Pais("Belleheve", 100000));
        paises.add(new Pais("Indigo", 1000000));
        return paises;
    }
}
