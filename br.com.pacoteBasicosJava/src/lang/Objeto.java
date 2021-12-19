package lang;

import modelos.Pessoa;
import modelos.Veiculo;

/**Se um Object é o pai de todos os objetos de java, então posso usar polimorfismo a nível de Object?*/
public class Objeto {
    public static void main(String[] args) {
        /**Sim, podemos usar nosso pai Object como um polimorfismo poderoso*/
        Pessoa umObjetoQueRepresentaUmaPessoa = new Pessoa("Lucas",22,"123");
        Veiculo umObjetoQueRepresentaVeiculo = new Veiculo("Hyundai","HB20");
        
        /**Eu posso enxergar o polimorfismo passando como argumento ambos meus objetos especificos
         * para um método que recebe um Object, e ele compila:*/
        receboUmObjeto(umObjetoQueRepresentaUmaPessoa);
        receboUmObjeto(umObjetoQueRepresentaVeiculo);

        /**Outra forma é referenciar como um Object, mas instanciar como um objeto específico*/
        Object objetoRecebendoUmaPessoa = new Pessoa("Lauro",19,"8");
        Object objetoRecendoUmVeiculo = new Veiculo("Mercedes","Optimus Prime");

    }
    
    public static void receboUmObjeto(Object objeto){
        Object objetoRecebido = objeto.getClass();
        System.out.println(objetoRecebido);
    }
}
