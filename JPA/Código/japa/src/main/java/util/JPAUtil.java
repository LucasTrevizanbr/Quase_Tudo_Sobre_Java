package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

    public static EntityManager criarEntityManager(){
        EntityManager entityManager = FACTORY.createEntityManager();
        return entityManager;
    }

}
