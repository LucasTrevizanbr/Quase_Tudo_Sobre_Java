package controladores;

import banco_dados_fake.GerarObjetos;
import modelos.Cidade;

import java.util.List;

public class CidadeController  {

    /**Interface genérica*/
    private GerarObjetos geradorObjetos;

    /**Recebemos nossa dependência por parâmetro, e deixamos que o container já instancie ela pra gente*/
    public CidadeController(GerarObjetos geradorObjetos) {
        this.geradorObjetos = geradorObjetos;
    }

    private CidadeController(String umArgumentoProConstrutorParametrizado){
        System.out.println("usei construtor privado e com parâmetro");
        System.out.println("Você digitou isso: "+umArgumentoProConstrutorParametrizado);
    }

    private List<Cidade> listar(){
        return geradorObjetos.listar();
    }

    private Cidade buscarCidadePorNome(String nome){
        Cidade cidadeEncontrada = geradorObjetos.buscarCidadePorNome(nome);
        return cidadeEncontrada;
    }

    public void metodoSemParametro(){
        System.out.println("sou um método sem parâmetro da classe CidadeController e acabei" +
                "de ser invocado");
    }



}
