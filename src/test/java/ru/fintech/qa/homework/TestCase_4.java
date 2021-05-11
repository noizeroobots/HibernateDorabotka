package ru.fintech.qa.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import ru.fintech.qa.homework.utils.*;

public class TestCase_4 {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    // Сначала инсерт объекта с Id = 6, и сразу получаю объект с Id = 6.
    @Test
    public void testCase_4_AddTheNextPlace() {
        Places places = new Places();
        places.setId(6);
        places.setRow(700);
        places.setPlace_num(100);
        places.setName("Hell");
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(places);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(new DbClient().getPlacesById(6));
    }
}