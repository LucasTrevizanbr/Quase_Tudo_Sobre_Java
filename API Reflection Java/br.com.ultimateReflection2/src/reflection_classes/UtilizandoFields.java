package reflection_classes;

import modelos.Produto;

import java.lang.reflect.Field;

public class UtilizandoFields {
    public static void main(String[] args) throws IllegalAccessException {
        /**Usamos o tipo Object pq queremos trabalhar com qlql objeto*/
        Object produto = new Produto("Raquete elétrica",20.50,"Panasonic");
        Class<?> classe = produto.getClass();

        /**Iterando pelo meu objeto pegando seus atributos*/
        for(Field atributo: classe.getDeclaredFields()){
            atributo.setAccessible(true);
            /**No get do valor eu preciso passar o Objeto que to usando*/
            System.out.println("atributo: "+atributo.getName() +" valor: "+atributo.get(produto));
        }

        /**Se você precisa pegar atributos da superClasse usa o getFields(), se quiser pegar um
         * único atributo usa getField(String nome), pros atributos privados use o getDeclared*/
    }
}
