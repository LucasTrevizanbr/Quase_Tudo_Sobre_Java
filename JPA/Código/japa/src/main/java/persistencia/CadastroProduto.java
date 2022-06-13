package persistencia;

import dao.CategoriaDao;
import dao.ProdutoDao;
import modelo.Categoria;
import modelo.Produto;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProduto {
    public static void main(String[] args) {
        criarObjetos();

        EntityManager entityManager = JPAUtil.criarEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        System.out.println(produtoDao.buscarPrecoPorNomeProduto("Geladeira gamer"));
    }

    private static void criarObjetos() {
        Categoria celulares = new Categoria("Celulares");
        Categoria eletrodoMestico = new Categoria("Eletrodoméstico");
        Produto celular = new Produto("Nokia", "Velho",new BigDecimal(10000), celulares);
        Produto geladeira = new Produto("Geladeira gamer","razer", new BigDecimal(20000)
                , eletrodoMestico);

        EntityManager entityManager = JPAUtil.criarEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        categoriaDao.cadastrar(eletrodoMestico);
        produtoDao.cadastrar(geladeira);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
