package com.bjit.training.dao;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bjit.training.model.LogIn;
import com.bjit.training.model.User;
import com.mysql.jdbc.ResultSet;

//public   class UserDAOImpl implements UserDAO {
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	// public UserDAOImpl(DataSource dataSource) {
	// jdbcTemplate = new JdbcTemplate(dataSource);
	// }

	private DataSource dataSource;

	//
	public void setDataSource(DataSource dataSource) {
		// jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}
	// @Autowired
	//
	// DataSource datasource;
	//
	// @Autowired
	//
	// JdbcTemplate jdbcTemplate;
	//

	// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	public void save(User user) {
		// TODO Auto-generated method stub

		System.out.println("Save user " + user.getId());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		if (user.getId() > 0)

		{

			String sql = "UPDATE user SET name=?, email=?, address=?, " + "gender=?, role=?, password=? WHERE id=?";
			jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAddress(), user.getGender(),
					user.getRole(), user.getPassword(), user.getId());

		} else {

			String sql = "INSERT INTO user (name, email, address, password, gender,role)" + " VALUES (?, ?, ?, ?,?,?)";
			jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAddress(), user.getPassword(),
					user.getGender(), user.getRole());

		}

	}

	public List<User> userDetails() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//
		String sql = "select * from user";

		List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {

			public User mapRow(java.sql.ResultSet resultSet, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();

				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setGender(resultSet.getString("gender"));
				user.setRole(resultSet.getString("role"));

				return user;
			}

		});
		return listUser;
	}

	public User updateUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getSpecificUser(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper() {
			public User mapRow(java.sql.ResultSet resultSet, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setAddress(resultSet.getString("address"));

				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setRole(resultSet.getString("role"));
				user.setGender(resultSet.getString("gender"));
				return user;
			}
		});
		return user;

	}

	public void deleteSpecificUser(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "DELETE from user WHERE id=?";
		jdbcTemplate.update(sql, id);
		// return null;
	}

	public User getSpecificUserByEmail(String email, String password) {
		

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		List<Map<String,Object>> l = jdbcTemplate.queryForList("select * from user where email = 'tania@gmail.com'	");
		
		List<Map<String,Object>> l = jdbcTemplate.queryForList("select * from user where email = '"+email+"'"
		+"and password = '"+password+"'");
		if(l.size()>0) {
			User u = new User();
			u.setName((String)l.get(0).get("name"));
			u.setAddress((String)l.get(0).get("address"));
			u.setEmail((String)l.get(0).get("email"));
			u.setPassword((String)l.get(0).get("password"));
			u.setGender((String)l.get(0).get("gender"));
			u.setRole((String)l.get(0).get("role"));
//			u.setAge((Integer)l.get(0).get("age"));
			return u;
		}return null;
	}

	public User validateUser(LogIn login) {
		System.out.println("ok ok from validateuser");

		String sql = "select * from users where email='" + login.getEmail() + "' and password='" + login.getPassword()
				+ "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	class UserMapper implements RowMapper<User> {
		public User mapRow(java.sql.ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail("email");
			user.setAddress(rs.getString("address"));
			user.setRole(rs.getString("role"));
			user.setGender(rs.getString("gender"));
			return user;
		}

	}
}
