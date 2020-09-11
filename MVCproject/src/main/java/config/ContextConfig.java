package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.UserDao;
import dao.UserDaoImpl;
import service.UserService;
import service.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = "dao, service")
public class ContextConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/users&teams?useUnicode=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
//	@Bean
//	public UserDao getUserDao(){
//		return new UserDaoImpl(getJdbcTemplate());		
//	}
//	@Bean
//	public UserService getUserService() {
//		return new UserServiceImpl(getUserDao());
//	}
	
}
