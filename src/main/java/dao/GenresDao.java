package dao;

import entities.Genres;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
@Transactional
public class GenresDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Genres getGenreById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Genres where genreId = :id");
        q.setParameter("id", id);
        List<Genres> gl = q.list();
        Genres res = gl.get(0);
        session.getTransaction().commit();
        session.close();
        return res;
    }

    public int addGenre(String name) {
        Genres g = new Genres();
        g.setName(name);
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(g);
        Query q = session.createQuery("from Genres");
        List<Genres> gl = q.list();
        int res = gl.get(gl.size() - 1).getGenreId();
        session.getTransaction().commit();
        session.close();
        return res;
    }
}
