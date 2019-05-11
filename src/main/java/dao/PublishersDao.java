package dao;

import entity.Publishers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@EnableTransactionManagement
@Transactional
public class PublishersDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Publishers getPublisherById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Publishers where publisherId = :id");
        q.setParameter("id", id);
        List<Publishers> pl = q.list();
        Publishers res = pl.get(0);
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public Publishers getPublisherByName(String name) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Publishers where name = :name");
        q.setParameter("name", name);
        List<Publishers> pl = q.list();
        Publishers res = pl.get(0);
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public int addPublisher(String name, String city, String country) {
        Publishers p = new Publishers();
        p.setName(name);
        p.setCity(city);
        p.setCountry(country);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(p);
        Query q = session.createQuery("from Publishers");
        List<Publishers> pl = q.list();
        int res = pl.get(pl.size() - 1).getPublisherId();
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public void removePublisher(int id) {
        Publishers p = getPublisherById(id);
        Session session = factory.openSession();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }
}
