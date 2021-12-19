package controladores;

import banco_dados_fake.GerarObjetos;
import modelos.Cidade;

import java.util.List;

public class CidadeController {

    public CidadeController() {
    }

    private CidadeController(String umArgumentoProConstrutorParametrizado){
        System.out.println("usei construtor privado e com parâmetro");
        System.out.println("Você digitou isso: "+umArgumentoProConstrutorParametrizado);
    }

    private List<Cidade> listar(){
        return GerarObjetos.listarCiddes();
    }

    private Cidade buscarCidadePorNome(String nome){
        Cidade cidadeEncontrada = GerarObjetos.acharCidadePorNome(nome);
        return cidadeEncontrada;
    }

    public void metodoSemParametro(){
        System.out.println("sou um método sem parâmetro da classe CidadeController e acabei" +
                "de ser invocado");
    }



}
