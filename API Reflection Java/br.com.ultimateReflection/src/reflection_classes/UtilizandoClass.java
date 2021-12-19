package reflection_classes;

import controladores.CidadeController;

/**
 * Nessa classe vamos entender o conceito da classe Class de reflection, essa Class é parametrizada
 * com outra classe, onde podemos então ter um objeto de Class que infere sobre uma determinada classe
 * por exemplo: Class<Cidade> = um objeto class que infere sobre cidade
 */
public class UtilizandoClass {
    /**Aqui vemos métodos para instânciar objetos de class inferindo nas classes que queremos*/
    public static void main(String[] args) throws ClassNotFoundException {

        /**A primeira maneira é bem simples, eu parametrizo um objeto de class e chamo um método
         * literal da minha classe parametrizada, pronto tenho um objeto de class que infere na
         * classe CidadeController*/
        Class<CidadeController> controllerCidadeClass = CidadeController.class;

        /**Uma outra maneira é instânciar atraves do getClass() de algum objeto, como estamos chamando
         * de um objeto desconhecido temos a "?" como parametro*/
        Class<? extends Class> controllerCidade2 = controllerCidadeClass.getClass();

        /**Outra maneira é com o uso do método static de Class, onde precisamos passar o
         * fully-qualified name da classe(nome do pacote e da classe) e também reparamos
         * a ? no tipo, pq esse método pode me devolver qualquer tipo de classe */
        Class<?> objeto = Class.forName("controladores.CidadeController");

        /**Instanciando um objeto Class eu estou criando um objeto que consegue ter acesso
         * a tudo que minha classe CidadeController tem, então eu tenho um objeto Class
         * da minha Classe de cidadeController que consegue inferir sobre todos os métodos
         * atributos, construtores etc */

    }
}
