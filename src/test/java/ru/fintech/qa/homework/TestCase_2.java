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
public class TestCase_2 {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    @Order(1)
    public void testCase_1_AddId_1() {
        Animal animal_id_1 = new Animal();
        animal_id_1.setName("Tanos");
        animal_id_1.setAge(25);
        animal_id_1.setType(1);
        animal_id_1.setId(1);
        animal_id_1.setPlace(1);
        animal_id_1.setSex(1);
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(animal_id_1);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        System.out.println(new DbClient().getAnimalById(1));
    }
}
