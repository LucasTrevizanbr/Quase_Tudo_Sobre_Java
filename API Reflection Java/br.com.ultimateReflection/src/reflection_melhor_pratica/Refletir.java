package reflection_melhor_pratica;

/**
 * Classe responsável majoritariamente por refletir uma Class e entrega-la para manipulacao.
 */
public class Refletir {

    /**Esse meu método principal vai criar uma Class de acordo com o fully-qualified-name recebido
     * e entregar para um manipulador, basicamente ele inicia o processo de "ligamento*/
    public ManipuladorClass refleteClasse(String nomeCompletoQualificado){
        try {
            Class<?> classeControle = Class.forName(nomeCompletoQualificado);
            return new ManipuladorClass(classeControle);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
