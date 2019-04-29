package dao;

import entities.Workers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class WorkersDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Workers getWorkerById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Workers where workerId = :id");
        q.setParameter("id", id);
        List<Workers> wl = q.list();
        Workers res = wl.get(0);
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public int addWorker(String name, String email, String pswd) {
        Workers w = new Workers();
        w.setEmail(email);
        w.setName(name);
        w.setPassword(pswd);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(w);
        Query q = session.createQuery("from Workers");
        List<Workers> wl = q.list();
        int res = wl.get(wl.size() - 1).getWorkerId();
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public void removeWorker(int id) {
        Workers w = getWorkerById(id);
        Session session = factory.openSession();
        session.delete(w);
        session.getTransaction().commit();
        session.close();
    }
}
