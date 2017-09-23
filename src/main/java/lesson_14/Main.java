package lesson_14;

import lesson_14.models.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
             //Criteria criteria = session.createCriteria(Product.class,"p");
             Criteria criteria = session.createCriteria(Product.class);
             //criteria.uniqueResult();
             criteria.add(Restrictions.eq("title","wfvg"));
             //criteria.add(Restrictions.between("id",10,20));
             //criteria.add(Restrictions.like("price","asdedw"));
             //criteria.add(Restrictions.or(Restrictions.not(Restrictions.in("id",1,1,1))));
             products = criteria.list();

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
