package lang;

import modelos.Pessoa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**Quando falamos de igualdade entre objetos estamos querendo dizer o que?*/
public class MetodoEquals {
    public static void main(String[] args) {
        /**Se eu tenho dois objetos de pessoa que tem o mesmo nome e o mesmo CPF então eu sei que são
         * a mesma pessoa:*/
        Pessoa pessoaUm = new Pessoa("Lucas", 22, "12345678");
        Pessoa pessoaDois = new Pessoa("Lucas", 22, "12345678");

        /**ERRADO!!! Eu tenho duas referências de objeto, o java entende que isso são dois objetos
         * diferentes, para que o java saiba que eles são iguais eu preciso sobrescrever o método equals
         * da classe que eu quero comparar. Fazendo isso eu digo que campos eu considero que sendo iguais
         * representam o mesmo objeto, Aqui tu precisa ver a classe de Pessoa para ver o método
         */
        List<Pessoa> pessoaList = new ArrayList();
        pessoaList.add(pessoaUm);
        System.out.println(pessoaList.contains(pessoaDois));

    }
}
