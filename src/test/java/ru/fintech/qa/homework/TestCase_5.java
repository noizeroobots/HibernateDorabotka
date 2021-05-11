package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import ru.fintech.qa.homework.utils.*;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase_5 {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    // тут не смог массив сделать из объектов поля name таблицы Zoo(((
    @Test
    public void testCase_1_Zoo() {
        Transaction transaction = null;
        Zoo zoo = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Zoo> zoo_name = (List<Zoo>) session.createNativeQuery("select name from zoo").list();

            String[] expectedArray = {"Центральный", "Северный", "Западный"};
   //         Assertions.assertArrayEquals(expectedArray, zoo);
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