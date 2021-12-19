package app;

import reflection_melhor_pratica.BuilderParametrosQuery;

import java.util.Map;

/**
 * Classe responsável por receber a requisição e devolver para a gente informações tratadas
 * para que possamos utilizas na hora da reflexão.
 */
public class Requisicao {

    private String nomeController;
    private String nomeMetodo;
    private Map<String, Object> parametrosQuery;

    /**padrao do request "/EntidadeController/nomeMetodo?param1=valor1&param2=valor2"*/
    public Requisicao(String urlRequisicao) {
        /**Tiro a primeira "/" da url de requisicao e a divido pela "?" para separarmos os parametros
         * do controlador e metodo*/
        String[] partesUrl = urlRequisicao.replaceFirst("/","").split("[?]");

        /**Atribuo meu controlador e metodo a um array de String*/
        String[] controllerEMetodo = partesUrl[0].split("/");

        /**Pego meu primeiro indice com o nome do Controller e o trato para que a leitura da class seja correta*/
        String nomeController = Character.toUpperCase(controllerEMetodo[0].charAt(0))+
                controllerEMetodo[0].substring(1)+"Controller";

        /**Atribuo as informações tratadas no meu objeto de requisicao construido*/
        this.nomeController = nomeController;
        this.nomeMetodo = controllerEMetodo[1];

        /**Para atribuir meus parametros de query ao Map, vou utilizar um utilitário que irá tratar
         * a parte da URL para um map e devolvendo esse map tratado, aqui também uso um ternário caso
         * eu não tenha parametros na url, o que vai me retornar um map apenas.*/
        this.parametrosQuery = partesUrl.length > 1
                               ? new BuilderParametrosQuery().comParametros(partesUrl[1]).construirMap()
                               : new BuilderParametrosQuery().construirMap();
    }

    public String getNomeController() {
        return nomeController;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Map<String, Object> getParametrosQuery() {
        return parametrosQuery;
    }
}
