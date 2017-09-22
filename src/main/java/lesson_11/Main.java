package lesson_11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //Получаем сесию
        Session session = sessionFactory.openSession();

        try {
            //Начать транзакцию
            session.beginTransaction();

            //Разные запрросы ..............

            //Закончить тракзачиюю
            session.getTransaction().commit();
        } catch (Exception e) {
            //Откат транзакции
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
