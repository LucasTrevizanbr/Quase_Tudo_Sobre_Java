package dao;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProdutoDao {

    private EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto){
        entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id){
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "from Produto";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome){
        String jpql = "FROM Produto p WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeCategoria(String nome){
        String jpql = "FROM Produto p WHERE p.categoria.nome = :nome";

        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome",nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoPorNomeProduto(String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";

        return entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome",nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> from = query.from(Produto.class);

        Predicate filtros = builder.and();

        if(nome != null && !nome.trim().isEmpty()){
            filtros = builder.and(filtros, builder.equal(from.get("nome"),nome));
        }
        if(dataCadastro != null){
            filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        }
        if(preco != null){
            filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));
        }

        query.where(filtros);
        return entityManager.createQuery(query).getResultList();
    }

}
