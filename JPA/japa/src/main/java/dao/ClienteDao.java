package dao;

import modelo.Cliente;
import modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Cliente cliente){
        entityManager.persist(cliente);
    }

    public Cliente buscarPorId(Long id){
        return entityManager.find(Cliente.class, id);
    }
}
