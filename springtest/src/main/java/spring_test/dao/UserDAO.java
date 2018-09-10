package spring_test.dao;

import spring_test.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
}
