package utils;

import modelos.Pessoa;

import java.util.Comparator;

public class NomePessoaComparator implements Comparator<Pessoa> {
    /**Implementando agora um critério por nome*/
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        String nomePessoa1 = p1.getNome();
        String nomePessoa2 = p2.getNome();

        return nomePessoa1.compareTo(nomePessoa2);
    }
}
