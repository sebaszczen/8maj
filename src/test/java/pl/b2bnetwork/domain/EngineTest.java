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

        TypedQuery<Car> query = entityManager.createQuery("select *  from car", Car.class);
        List<Car> resultList = query.getResultList();
        for (Car car : resultList) {
            System.out.println(car.toString());
        }

        entityManager.close();
        entityManagerFactory.close();
        }
    }

