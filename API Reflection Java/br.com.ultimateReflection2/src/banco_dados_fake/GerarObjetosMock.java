package banco_dados_fake;

import modelos.Cidade;

import java.util.*;

/**mock implementa a interface genérica e fornece os dados do seu próprio jeito*/
public class GerarObjetosMock implements GerarObjetos{

    @Override
    public List<Cidade> listar() {
        List<Cidade> listaInstanciada = new ArrayList<>();
        Cidade cidadeUm = new Cidade("São Paulo","SP","12,33 milhões");
        Cidade cidadeDois = new Cidade("Minas Gerais","MG","20,87 milhões");
        Cidade cidadeTres = new Cidade("Rio Grande do Sul","RS","11,29 milhões");

        listaInstanciada.add(cidadeUm);
        listaInstanciada.add(cidadeDois);
        listaInstanciada.add(cidadeTres);

        return listaInstanciada;
    }

    @Override
    public Cidade buscarCidadePorNome(String nome) {
        List<Cidade> listaCidades = listar();
        Optional<Cidade> cidadeEncontrada = listaCidades.stream().filter(cidade ->
                cidade.getNome().equals(nome)).findFirst();

        if(cidadeEncontrada.isEmpty()){
            System.out.println("Cidade: "+nome+" não encontrada na base");
        }

        return cidadeEncontrada.get();
    }
}
