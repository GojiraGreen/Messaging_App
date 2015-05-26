package com.messages.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("userDao")
public class UserDao {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Create user
	 * @param user
	 * @return
	 */
	public void create(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	/**
	 * Check if user exist in database
	 * @param username
	 * @return
	 */
	public boolean exists(String username) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.idEq(username));
		User user = (User) criteria.uniqueResult();
		return user != null;
	}

	/**
	 * Get list of all users
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User").list();
		//return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}
	
}
