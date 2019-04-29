package service;

import dao.ClientsDao;
import entities.Clients;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientsService {
    @Autowired
    ClientsDao dao;

    public int add(Clients client) {
        return dao.add(client);
    }

    public int update(Clients client) {
        return dao.update(client);
    }

    public int delete(int id) {
        return dao.delete(id);
    }

    public Clients get(int id) {
        return dao.get(id);
    }

    public List<Clients> list() {
        return dao.list();
    }
}
