package ru.fintech.qa.homework;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import ru.fintech.qa.homework.utils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCase_3 {

    @BeforeAll
    public static void beforeAll() {
        BeforeUtils.createData();
    }

    @Test
    @Order(1)
    public void testCase_1_null() {
        Workman workman = new Workman();
        workman.setName(null);
        workman.setAge(25);
        workman.setPosition(1);
        workman.setId(1);
        Transaction transaction = null;
        try (Session session = HibernateSessionCreator.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(workman);
            transaction.commit();
            session.close();
       // } catch (ConstraintViolationException e) {
        } catch (Exception e) {
            System.out.println("The message: " + e);
        } finally {
            System.out.println("Значение NULL не разрешено для поля \"name\"");
        }
        System.out.println(new DbClient().getWorkmanByName(null));
    }
}
