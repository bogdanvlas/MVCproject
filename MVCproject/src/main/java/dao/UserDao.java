package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	
	List<User> findAll();
	
	void save(User user);
	
	User getById(int id);
	
	void deleteById(int id);
	
	void update(User user);
	
	
	
	
}
