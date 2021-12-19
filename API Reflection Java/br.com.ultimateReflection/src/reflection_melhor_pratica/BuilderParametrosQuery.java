package reflection_melhor_pratica;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe utilitária para atribuir nosos parametros da url a um map de chave e valor
 */
public class BuilderParametrosQuery {

    /** Eu quero um map já formatado com minha chave e valor, então óbviamente preciso dele como atributo*/
    private Map<String, Object> queryParams = new HashMap<>();

    /**Garanto no meu construtor que terei minha String com os parametro para query*/
    public BuilderParametrosQuery comParametros(String stringQueryParams) {

        /**Divido minha string pelo "&" padrão em url de requisição, aqui já estamso recebendo ela
         * depois do "?" : "/controller/metodo?parametro=valor&parametro2=valor2" */
        String[] stringsDeParametro = stringQueryParams.split("&");

        /** Vou iterar sobre meu array de parametros, pegando cada String já splitada pelo "&"
         * que nesse caso é :"parametro=valor"*/
        for (String stringParametro : stringsDeParametro) {

            /**Então splita-la novamente para termos a chave e o valor*/
            String[] chaveEValor = stringParametro.split("=");

            String chave = chaveEValor[0];
            Object valor = chaveEValor[1];

            /**Que serão inseridas no nosso map*/
            queryParams.put(chave, valor);
        }

        /**Devolvo minha própria classe com a "formatação" feita*/
        return this;
    }

    /**Linko com o construirMap que devolve enfim o mapa*/
    public Map<String, Object> construirMap() {
        return this.queryParams;
    }

}
