package lesson_12;

import lesson_12.models.Product;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
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

        List<Object> products = null;
        try {
            //Начать транзакцию
            session.beginTransaction();

            //Разные запрросы ..............
            SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title= ? WHERE id= ?");
            queryUpdate.setParameter(0, "gqwgg");
            queryUpdate.setParameter(1, "1");
            queryUpdate.executeUpdate();

            /* SQLQuery queryUpdate = session.createSQLQuery("UPDATE product SET title= :title WHERE id= :id");
            queryUpdate.setParameter("title", "gqwgg");
            queryUpdate.setParameter("id", "1");
            queryUpdate.executeUpdate();*/


           // SQLQuery querySelect = session.createSQLQuery("SELECT * FROM product");
            SQLQuery querySelect = session.createSQLQuery("SELECT {p.*}, {pc.*} FROM product p INNER JOIN product_category pc ON p.product_category_id=pc.id");
            querySelect.addEntity("p",Product.class);
            querySelect.addJoin("pc","p.productCategory");
            products=querySelect.list();

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

        for(Object obj: products){
            System.out.println(obj);
        }

        /*
        for(Iterator iterator = products.iterator(); iterator.hasNext();){
            Product product =(Product) iterator.next();
            System.out.println(product.toString());
        }*/

    }
}
