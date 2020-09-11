package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;

public interface UserService {

	List<User> findAll();

	void save(User user);

	User getById(int id);

	void deleteById(int id);

	void update(User user);

}
