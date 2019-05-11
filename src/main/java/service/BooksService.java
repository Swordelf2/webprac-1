package service;

import dao.BooksDao;
import entity.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BooksService {
    @Autowired
    BooksDao dao;

    public int add(Books book) {
        return dao.add(book);
    }

    public int delete(int id) {
        return dao.delete(id);
    }

    public Books get(int id) {
        return dao.get(id);
    }

    public List<Books> list() {
        return dao.list();
    }

    public List<Books> getBooksByFilter(String name,
                                  double minprice, double maxprice,
                                  int cover /* 0 - doesn't matter, 1 - soft, 2 - hard */,
                                  int inplace /* 0 - doesn't matter, 1 - in place */) {
        return dao.getBooksByFilter(name, minprice, maxprice, cover, inplace);
    }
}
