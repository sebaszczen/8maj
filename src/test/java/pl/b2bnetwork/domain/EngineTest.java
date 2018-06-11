package pl.b2bnetwork.domain;


import org.junit.Test;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EngineTest {


    @Test
    public void test(){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Engine> query = entityManager.createQuery("select e from Engine e", Engine.class);
        List<Engine> resultList = query.getResultList();

        for (Engine engine : resultList) {
            for (Part part : engine.getParts()) {
                System.out.println(engine.name+" "+engine.getEngineCat()+" part "+part.getName());
            }
        }

        entityManager.close();
        entityManagerFactory.close();
        }
    }

