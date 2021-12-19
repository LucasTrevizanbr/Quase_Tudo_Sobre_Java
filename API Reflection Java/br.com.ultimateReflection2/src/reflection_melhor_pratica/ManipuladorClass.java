package reflection_melhor_pratica;

import java.lang.reflect.Constructor;

/**
 * Essa classe ajuda a manipular objetos de Class que criaremos durante a reflexao.
 */
public class ManipuladorClass {

    /**Obviamente eu preciso que esse objeto de manipulação tenha uma Class a qual manipular*/
    private Class<?> classe;

    /**Então vou garantir que ele só seja instânciado com uma Class*/
    public ManipuladorClass(Class<?> classe){
        this.classe = classe;
    }

    /**Eu quero que meu manipulador de class possa entregar o construtor padrão da minha classe inferida.
     *Então eu vou ter esse método aqui, e começo a linkar com outros classes de manipulação, nesse caso
     *vou usar um Manipulador de Constructor para buscar o construtor padrão do que ta inferido na minha
     *Class */
    public ManipuladorConstructor getConstrutorPadrao() {
        try {
            Constructor<?> construtorPadrao = classe.getDeclaredConstructor();
            return new ManipuladorConstructor(construtorPadrao);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**Se eu já quiser criar uma instância com meu manipulador de classe eu consigo, basta
     * chamar meu getConstrutorPadrao que tenho na classe para me devolver um manipulador de
     * construtor e então instancia-lo com o próprio metodo do manipuladorConstrutor*/
    public ManipuladorObjeto criarInstancia() {
        Object instancia = getConstrutorPadrao().instanciar();
        return new ManipuladorObjeto(instancia);
    }
}
