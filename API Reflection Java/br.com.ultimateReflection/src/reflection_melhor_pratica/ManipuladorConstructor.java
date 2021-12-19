package reflection_melhor_pratica;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Essa minha classe vai lidar com os construtores que meu objeto de Class vai poder inferir.
 */
public class ManipuladorConstructor {

    /**Seguindo a lógica, eu preciso que esse meu manipulador de construtor tenha um  Constructor*/
    private Constructor<?> construtor;

    /**E vou garantir que ele só seja instânciado com um construtor recebido*/
    public ManipuladorConstructor(Constructor<?> construtor) {
        this.construtor = construtor;
    }

    /**Eu quero poder instanciar o objeto inferido na minha class através do meu construtor, então é justo
     * que eu tenha esse método que vai apenas chamar uma nova instância do objeto inferido usando meu
     * construtor*/
    public Object instanciar() {
        try {
            return construtor.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new RuntimeException("Erro ao instânciar objeto : "+e.getTargetException());
        }
    }
}
