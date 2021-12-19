package conversor;

import anotacoes.NomeTagXml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;

public class ConversorXML {

    public String converte(Object objeto) {

        try {
            Class<?> classeObjeto = objeto.getClass();
            StringBuilder criadorXml = new StringBuilder();

            /**Se meu objeto for uma lista, eu preciso ter uma tag Raiz de <lista></lista> no XML, e as
             * tags filhos serão <produto></produto>*/
            if (objeto instanceof Collection) {
                Collection<?> colecaoDeObjeto = (Collection<?>) objeto;

                criadorXml.append("<lista>");
                for (Object obj : colecaoDeObjeto) {
                    String xml = converte(obj);
                    criadorXml.append(xml);
                }
                criadorXml.append("</lista>");
            } else {
                /**Recuperamos a anotação(a que criamos) que nossa Classe de objeto tem*/
                NomeTagXml anotacaoClasse = classeObjeto.getDeclaredAnnotation(NomeTagXml.class);

                /**Agora que recuperei o objeto de Anotacao, posso atribuir o valo que ele carrega
                 * caso não seja nullo*/
                String nomeClasse =
                        anotacaoClasse == null
                        ? classeObjeto.getSimpleName() : anotacaoClasse.value();

                criadorXml.append("<" + nomeClasse + ">");
                for (Field atributo : classeObjeto.getDeclaredFields()) {
                    atributo.setAccessible(true);

                    NomeTagXml anotacaoAtributo = atributo.getDeclaredAnnotation(NomeTagXml.class);

                    String nomeAtributo = anotacaoAtributo == null ?
                            atributo.getName() : anotacaoAtributo.value();

                    Object valorAtributo = atributo.get(objeto);

                    criadorXml.append("<" + nomeAtributo + ">");
                    criadorXml.append(valorAtributo);
                    criadorXml.append("</" + nomeAtributo + ">");
                }
                criadorXml.append("</" + nomeClasse + ">");
            }

            return criadorXml.toString();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro na geração do XML: " + e.getMessage());
        }


    }
}
