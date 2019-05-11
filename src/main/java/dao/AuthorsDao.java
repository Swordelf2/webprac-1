package dao;

import entity.Authors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


@EnableTransactionManagement
@Transactional
public class AuthorsDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Authors getAuthorById(int id) {
        Session session = factory.openSession();
        Authors author = (Authors) session.get(Authors.class, id);
        session.close();
        return author;
    }

    @Transactional
    public Authors getAuthorByName(String name) {
        Session session = factory.openSession();
        Authors author = (Authors) session.createQuery("from Authors where name = :name").list().get(0);
        session.close();
        return author;
    }

    @Transactional
    public int addAuthor(Authors author) {
        Session session = factory.openSession();
        Serializable id = session.save(author);
        session.close();
        return (int) id;
    }

    @Transactional
    public int removeAuthor(int id) {
        Session session = factory.openSession();
        Authors author = (Authors) session.get(Authors.class, id);
        session.delete(author);
        Serializable identifier = session.getIdentifier(author);
        session.flush();
        session.close();
        return (int) identifier;
    }
}
