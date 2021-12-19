package app;

import modelo.Nacao;
import modelo.Pais;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Usando o conjunto de set para representar países de uma nação, não existem países repetidos no reino
 * então a implementação de um set se faz mais adequada, lembrando do GRANDE ganho de performance ao obter e
 * remover elementos em relação a uma lista.
 *
 * -> equals():
 * Ao instanciarmos um pais orderGold com os mesmos dados do pais preenchido no método estatico,
 * perguntamos se nossa nacao ja conquistou aquela pais e o resultado é false, isso acontece pelo fato do
 * método equals() não estar sobrescrito com o que NÓS consideramos como igualdade entre os objetos.
 * -> Mesmo sobrescrevendo o método equals dizendo que o NOME do meu pais é meu critério de igualdade entre
 * os objetos, o resultado ainda se mantém false ao perguntar se o pais ja foi conquistado pela nação.
 * Isso acontece porque o método hashCode() não foi sobrescrito junto com o método equals(), basicamente
 * falando o hashCode é um número que garante que qualquer objeto de pais que tenha o mesmo nome é DE FATO
 * O MESMO PAIS(isso está ligado a maneira como o set é eficiente ao buscar objetos)
 * -> Sobrescrevendo também o método hashCode  conseguimos o resultado esperado.
 *
 */
public class PrincipalConjuntoSet {

    public static void main(String[] args) {
        Nacao nacao = new Nacao("Empério Shiaq",2);
        nacao.setPaisesConquistados(gerarPaises());
        System.out.println(nacao.getPaisesConquistados());

        //Perguntando se o pais instanciado existe no set.
        Pais paisOrderGold = new Pais("OrderGold",667000);
        System.out.println(nacao.getPaisesConquistados().contains(paisOrderGold));

        /*Um modo mais antigo de percorrer Sets era usando o Iterator, um objeto que faz referencia a algum
        objeto de uma coleção*/
        Iterator<Pais> iterador = nacao.getPaisesConquistados().iterator();
        while(iterador.hasNext()){
            Pais paisAtual = iterador.next();
            System.out.println(paisAtual);
        }

    }

    public static Set<Pais> gerarPaises(){
        Set<Pais> paises = new HashSet<>();
        paises.add(new Pais("OrderGold",667000));
        paises.add(new Pais("Belleheve", 100000));
        paises.add(new Pais("Indigo", 1000000));
        return paises;
    }

}
