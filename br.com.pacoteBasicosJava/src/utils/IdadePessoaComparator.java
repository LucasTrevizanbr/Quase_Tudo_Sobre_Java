package utils;

import modelos.Pessoa;

import java.util.Comparator;

/**Uma interface é um "contrato" que a classe que implementa assina, sendo obrigada e implementar
 * os métodos que a interface tem. Aqui estamos assinando um contrato de Comparator parametrizado
 * para uma classe de Pessoa*/
public class IdadePessoaComparator implements Comparator<Pessoa> {

    /**Esse é o cara que somos obrigados a implementar por contratro, aqui eu tenho que falar pra ele
     * que baseado em algum critério eu vou retornar um inteiro. -1 se o objeto um é menor que o objeto
     * dois(vem antes), 1 se o objeto um for maior que o objeto dois(vem depois), e 0 se forem iguais*/
        @Override
        public int compare(Pessoa p1, Pessoa p2) {
            /**Um jeito mais bonito de se utilizar esse compara é usando a Classe Integer que já tem
             * um compare implementado quando ela assinou a interface, então só precisamos utiliza-lo*/
            return Integer.compare(p1.getIdade(), p2.getIdade());
        }
}
