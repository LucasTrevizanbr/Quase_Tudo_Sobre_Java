package emulador_client_side;

import reflection_melhor_pratica.Refletir;

import java.util.Map;

/**Classe principal para trabalhar com a url de maneira reflexiva*/
public class ControladorDeRota {

    private String pacoteBase;

    public ControladorDeRota(String pacoteBase) {
        this.pacoteBase = pacoteBase;
    }

    /**Esse é o método principal do controlador, onde toda a mágica da relfexão se inicia*/
    public Object excuta(String urlRequisicao) {
        /**Classe responsável por tratar a url de requisição recebida e devolver informações necessárias*/
        Requisicao requisicao = new Requisicao(urlRequisicao);
        String nomeController = requisicao.getNomeController();
        String nomeMetodo = requisicao.getNomeMetodo();
        Map<String, Object> parametros = requisicao.getParametrosQuery();

        /**Também com minhas classes de Relfexao eu consigo chamar um método*/
        Object retornoMetodo = new Refletir().refleteClasse(pacoteBase+nomeController)
                .criarInstancia()
                .getMetodo(nomeMetodo, parametros)
                .invocaMetodo();

        System.out.println(retornoMetodo);
        return retornoMetodo;
    }
}
