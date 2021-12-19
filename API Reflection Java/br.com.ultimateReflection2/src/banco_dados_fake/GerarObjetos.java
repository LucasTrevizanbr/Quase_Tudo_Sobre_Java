package banco_dados_fake;

import modelos.Cidade;

import java.util.List;

/**Nossa interface genérica que o controller recebe, posso implementar esses métodos em qualquer
 * "fonte de dados" que eu quiser usar*/
public interface GerarObjetos {

    public List<Cidade> listar();
    public Cidade buscarCidadePorNome(String nome);
}
