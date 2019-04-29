package dao;

import entities.Authors;
import entities.Books;
import entities.Publishers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


@EnableTransactionManagement
@Transactional
public class BooksDao {

    @Autowired
    SessionFactory factory;

    @Transactional
    public Books getBookById(int id) {
        Session session = factory.openSession();
        Books books  = (Books) session.get(Books.class, id);
        session.close();
        return books;
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
    public int addBook(String name, int publisher, double price, int year, int pages, String cover, int quantity,
                       String annotation, Set<Authors> authors) {
        Books b = new Books();
        b.setName(name);
        b.setPrice(new BigDecimal(price));
        b.setYear(year);
        b.setPages(pages);
        b.setCover(cover);
        b.setQuantity(quantity);
        b.setAnnotation(annotation);
        b.setAuthorSet(authors);

        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Publishers where publisherId = :id");
        q.setParameter("id", publisher);
        List<Publishers> pl = q.list();
        session.getTransaction().commit();
        session.close();

        Publishers p = pl.get(0);
        b.setPublishersByPublisherId(p);

        session = factory.openSession();
        session.beginTransaction();
        session.save(b);
        q = session.createQuery("from Books");
        List<Books> bl = q.list();
        int res = bl.get(bl.size() - 1).getBookId();
        session.getTransaction().commit();
        session.close();

        return res;
    }

    @Transactional
    public void removeBook(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("from Books where bookId = :id");
        q.setParameter("id", id);
        List<Books> bl = q.list();
        Books b = bl.get(0);
        session.delete(b);
        session.getTransaction().commit();
        session.close();
    }
}
