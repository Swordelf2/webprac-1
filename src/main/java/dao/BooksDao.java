package dao;

import entity.Books;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@EnableTransactionManagement
@Transactional
public class BooksDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Books get(int id) {
        Session session = factory.openSession();
        Books identifier = (Books) session.get(Books.class, id);
        session.close();
        return identifier;
    }

    /* get list of books which satisfy user's search query */
    @Transactional
    public List<Books> getBooksByFilter(String name,
                                      double minprice, double maxprice,
                                      int cover /* 0 - doesn't matter, 1 - soft, 2 - hard */,
                                      int inplace /* 0 - doesn't matter, 1 - in place */) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q;
        if (cover == 0 && inplace == 0) {
            q = session.createQuery("from Books where name like :name and price >= :minprice and price <= :maxprice order by bookId");
        } else if (cover == 0) {
            q = session.createQuery("from Books where name like :name and price >= :minprice and price <= :maxprice and quantity > 0" +
                    " order by bookId");
        } else if (inplace == 0) {
            q = session.createQuery("from Books where name like :name and price >= :minprice and price <= :maxprice and cover = :cover" +
                    " order by bookId");
            q.setParameter("cover", cover == 1 ? "мягкая" : "твердая");
        } else {
            q = session.createQuery("from Books where name like :name and price >= :minprice and price <= :maxprice " +
                    "and quantity > 0 and cover = :cover order by bookId");
            q.setParameter("cover", cover == 1 ? "мягкая" : "твердая");
        }
        q.setParameter("name", "%"+name+"%");
        q.setParameter("minprice", new BigDecimal(minprice));
        q.setParameter("maxprice", new BigDecimal(maxprice));

        List<Books> result = (List<Books>) q.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Transactional
    public int add(Books book) {
        Session session = factory.openSession();
        Serializable id = session.save(book);
        session.flush();
        session.close();
        return (Integer) id;
    }

    @Transactional
    public int delete(int id) {
        Session session = factory.openSession();
        Books client = (Books) session.get(Books.class, id);
        session.delete(client);
        Serializable identifier = session.getIdentifier(client);
        session.flush();
        session.close();
        return (Integer) identifier;
    }

    @Transactional
    public List<Books> list() {
        Session session = factory.openSession();
        @SuppressWarnings("unchecked")
        List<Books> list = session.createQuery("from Books").list();
        session.close();
        return list;
    }
}
