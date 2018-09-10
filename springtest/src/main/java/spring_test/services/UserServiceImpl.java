package spring_test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_test.dao.UserDAO;
import spring_test.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO dao;

    public List<User> getUsers() {
        return dao.getUsers();
    }
}
