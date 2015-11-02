package rs.djm.jblog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerWrapper {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jblog");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
