package lesson_13;

import lesson_13.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //Получаем сесию
        Session session = sessionFactory.openSession();

        /*
            Запросы Hibernate:
            1. SQL
            2. HQL
            3. Criteria
        */

        List<Product> products = null;

        try {
            //Начать транзакцию
            session.beginTransaction();

            //Разные запрросы ..............
            //Query query = session.createQuery("FROM Product");
            //Query query = session.createQuery("FROM Product as p INNER JOIN FETCH p.productCategory as pc");
            //Query query = session.createQuery("SELECT p FROM Product as p INNER JOIN FETCH p.productCategory as pc");
            //query.setParameter("id",1L);
            ///products = query.list();

            Product product = new Product();
            product.setDescription("svsdf");
            session.update(product);
            //session.save(product);
            //session.delete(product);



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

        for(Product product: products){
            System.out.println(product);
        }
    }
}
