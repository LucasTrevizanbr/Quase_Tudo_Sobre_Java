package anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**Anotações nada mais são que interfaces especiais, sub interfaces da inteface Anotations do pacote lang.
 * esse @ na frente da palavra chave "interface" foi como os criadores de Java desejaram evidenciar essa
 * diferença
 *
 * A primeira Regra a se criar uma anotação, é que ela NÃO PODE EXTENDER NENHUMA CLASSE NEM IMPLEMENTAR
 * NENHUMA INTERFACE!.
 * Também precisamos dizer ao java como ele deve usar essa anotação e fazemos isso com anotações, essas
 * são chamadas de metaAnotações..
 * */

//Aqui eu digo pro java levar em consideração a anotação em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
/**Qual o alvo a minha anotação?, aqui eu passo um array dizendo onde eu posso usar ela,
 * num ElementType.Type(posso usar na declaração de uma classe) e num
 * Field(posso usar num atributo de uma classe qualquer)*/
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface NomeTagXml {

    /**Por convenção, toda anotação que possue SOMENTE UM VALOR recebe o nome "value"*/
    public String value();

}
