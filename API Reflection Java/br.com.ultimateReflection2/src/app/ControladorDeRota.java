package app;

import banco_dados_fake.GerarObjetos;
import banco_dados_fake.GerarObjetosMock;
import container.ContainerIoC;
import conversor.ConversorXML;
import reflection_melhor_pratica.ManipuladorClass;
import reflection_melhor_pratica.ManipuladorObjeto;
import reflection_melhor_pratica.Refletir;

import java.util.Map;

/**Classe principal para trabalhar com a url de maneira reflexiva*/
public class ControladorDeRota {

    private String pacoteBase;

    /**Necessário para implementar a inversão de controle*/
    private ContainerIoC container;

    public ControladorDeRota(String pacoteBase) {
        this.pacoteBase = pacoteBase;
        this.container = new ContainerIoC();
    }

    public <T, K extends T> void registra(Class<T> tipoFonte,
                                Class<K> tipoDestino) {

        /**Digo ao meu Container que objeto destino ele usa pra objetos do tipo fonte(Interface)*/
        container.registra(tipoFonte, tipoDestino);
    }

    /**Esse é o método principal do controlador, onde toda a mágica da relfexão se inicia*/
    public Object excuta(String urlRequisicao) {
        /**Classe responsável por tratar a url de requisição recebida e devolver informações necessárias*/
        Requisicao requisicao = new Requisicao(urlRequisicao);
        String nomeController = requisicao.getNomeController();
        String nomeMetodo = requisicao.getNomeMetodo();
        Map<String, Object> parametros = requisicao.getParametrosQuery();

        /**Usando o container de inversão de controle*/
        Class<?> classeController = new Refletir().getClasse(pacoteBase+nomeController);

        /**Nosso container agora instância a classe de Controller*/
        Object instanciaController = container.getInstancia(classeController);

        /**Aproveitando a manipulador objeto, podemos entregar a instanciaController iniciada pelo container
         * com sua dependência já iniciada(GeradorObjetos)*/
        Object retornoMetodo = new ManipuladorObjeto(instanciaController)
                .getMetodo(nomeMetodo, parametros)
                .invocaMetodo();

        System.out.println(retornoMetodo);

        retornoMetodo = new ConversorXML().converte(retornoMetodo);

        return retornoMetodo;
    }
}
