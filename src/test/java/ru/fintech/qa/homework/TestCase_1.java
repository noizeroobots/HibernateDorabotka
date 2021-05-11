package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import ru.fintech.qa.homework.utils.*;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase_1 {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    @Order(1)
    public void testCase_1_no_9_lines() {
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
            Assertions.assertNotEquals(9, id.size());
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void testCase_2_exactly_10_lines() {
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
            Assertions.assertEquals(10, id.size());
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void testCase_3_no_11_lines() {
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Animal> id = (List<Animal>) session.createNativeQuery("select * from animal").list();
            Assertions.assertNotEquals(11, id.size());
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}