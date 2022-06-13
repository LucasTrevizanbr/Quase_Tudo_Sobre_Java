package dao;

import modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        entityManager.persist(categoria);
    }

    public void deletar (Categoria categoria){
        Categoria categoriaManaged = entityManager.merge(categoria);
        entityManager.remove(categoriaManaged);
    }

}
