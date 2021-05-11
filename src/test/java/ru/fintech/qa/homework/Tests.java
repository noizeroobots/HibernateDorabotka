package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import ru.fintech.qa.homework.utils.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    @Order(1)
    public void testCase_1_exactly_9_lines() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
        Assertions.assertEquals(9, id.size());
        sessionFactory.close();
    }

    @Test
    @Order(2)
    public void testCase_1_exactly_10_lines() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
        Assertions.assertEquals(10, id.size());
        sessionFactory.close();
    }

    @Test
    @Order(3)
    public void testCase_1_exactly_11_lines() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
        Assertions.assertEquals(11, id.size());
        sessionFactory.close();
    }

    @Test
    @Order(4)
    public void selectTestHibernatePo() {
        System.out.println(new DbClient().getAnimalByName("По"));
    }

//    @Test
//
//    public void cannotAddAStringWithIndex1(){
//        Animal animal = new Animal();
//        animal.setName("Tanos");
//        animal.setAge(25);
//        animal.setType(1);
//        animal.setId(1);
//        animal.setPlace(1);
//        animal.setSex(1);
//        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.save(animal);
//        System.out.println(new DbClient().getAnimalByName("Бусинка"));
//        sessionFactory.close();
//    }

    @Test
    public void dsd() {
        Animal animal = new Animal();
        animal.setName("Tanos");
        animal.setAge(25);
        animal.setType(1);
        animal.setId(15);
        animal.setPlace(1);
        animal.setSex(1);
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(animal);
        System.out.println(new DbClient().getAnimalByName("Tanos"));
        session.getTransaction().commit();
        sessionFactory.close();
    }

    //    @Test
//    @Order(5)
//    public void testCase_4_AddTheNextPlace() {
//        Places places = new Places();
//        places.setId(6);
//        places.setRow(7);
//        places.setPlace_num(100);
//        places.setName("Hell");
//        Transaction transaction = null;
//        try (SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
//             Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.save(places);
//            System.out.println(new DbClient().getPlacesById(6));
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
    @Test
    @Order(5)
    public void testCase_4_AddTheNextPlace() {
        Places places = new Places();
        places.setId(6);
        places.setRow(7);
        places.setPlace_num(100);
        places.setName("Hell");
        Session session = HibernateSessionCreator.getSessionFactory().openSession();
            session.save(places);
            session.close();
           System.out.println(new DbClient().getAllPlacesById(6));

    }

    @Test
    @Order(6)
    public void testCase_4_AddTheNextPlace6() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Places> id = (List<Places>) session.createNativeQuery("select * from places").list();
        Assertions.assertEquals(5, id.size());
        System.out.println(new DbClient().getPlacesById(5));
        sessionFactory.close();
    }
}