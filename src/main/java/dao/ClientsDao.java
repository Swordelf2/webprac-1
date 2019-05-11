package dao;

import entity.Clients;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@EnableTransactionManagement
@Transactional
public class ClientsDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public int add(Clients client) {
        Session session = factory.openSession();
        Serializable id = session.save(client);
        session.flush();
        session.close();
        return (Integer) id;
    }

    @Transactional
    public int update(Clients client) {
        Session session = factory.openSession();
        session.update(client);
        Serializable id = session.getIdentifier(client);
        session.flush();
        session.close();
        return (int) id;
    }

    @Transactional
    public int delete(int id) {
        Session session = factory.openSession();
        Clients client = (Clients) session.get(Clients.class, id);
        session.delete(client);
        Serializable identifier = session.getIdentifier(client);
        session.flush();
        session.close();
        return (Integer) identifier;
    }

    @Transactional
    public Clients get(int id) {
        Session session = factory.openSession();
        Clients identifier = (Clients) session.get(Clients.class, id);
        session.close();
        return identifier;
    }

    @Transactional
    public List<Clients> list() {
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        List<Clients> list = session.createQuery("from Clients").list();
        session.close();
        return list;
    }

    @Transactional
    public Clients clientByLogin(String login) {
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        List<Clients> clientsList = (List<Clients>) session
                .createQuery("from entity.Clients where email=:login").
                        setParameter("login", login).list();
        if (clientsList.size() == 0) {
            return null;
        } else {
            return clientsList.get(0);
        }
    }
}
