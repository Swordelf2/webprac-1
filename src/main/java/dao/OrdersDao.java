package dao;

import entities.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class OrdersDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Orders getOrderById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Orders where orderId = :id");
        q.setParameter("id", id);
        List<Orders> ol = q.list();
        Orders res = ol.get(0);
        session.getTransaction().commit();
        session.close();
        return res;
    }

    /* change status of the order */
    @Transactional
    public void changeStatus(int id, String s) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Orders where orderId = :id ");
        q.setParameter("id", id);
        List<Orders> ol = q.list();
        Orders o = ol.get(0);
        o.setStatus(s);
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }
}
