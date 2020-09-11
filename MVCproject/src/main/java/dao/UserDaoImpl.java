package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import entity.User;
import mapper.UserMapper;

@Component
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}

	@Override
	public void save(User user) {
		String sql = "INSERT users VALUES(?, ?)";
		jdbcTemplate.update(sql, user.getId(), user.getName());
	}

	@Override
	public User getById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
		return user;
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET name = ? WHERE id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getId());
	}
	
	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
