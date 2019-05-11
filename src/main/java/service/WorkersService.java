package service;

import dao.WorkersDao;
import entity.Workers;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkersService {
    @Autowired
    WorkersDao dao;

    public Workers workerByLogin(String login) {
        return dao.workerByLogin(login);
    }
}
