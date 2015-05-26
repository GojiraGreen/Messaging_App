package com.messages.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("messageDao")
public class MessageDao  {

	@Autowired
	private SessionFactory sessionFactory;
	

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Getting all messages from database
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Message> getMessages() {
		Criteria criteria = session().createCriteria(Message.class);
		criteria.createAlias("user", "u").add(Restrictions.eq(("u.enabled"), true));
		return criteria.list();
	}
	
	/**
	 * Getting all messages from database for certain user
	 * @param username
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String username) {
		Criteria criteria = session().createCriteria(Message.class);
		criteria.createAlias("message", "m");
		criteria.add(Restrictions.eq(("u.enabled"), true));
		criteria.add(Restrictions.eq("u.username", username));
		return criteria.list();
	}	

	/**
	 * Save or update message
	 * @param message
	 * @return
	 */
	public void saveOrUpdate(Message message) {
		session().saveOrUpdate(message);
	}
	
	/**
	 * Delete message by Id
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		Query query = session().createQuery("delete from Messsage where id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	/**
	 * Get message by Id
	 * @param id
	 * @return
	 */
	public Message getMessage(int id) {
		Criteria criteria = session().createCriteria(Message.class);
		criteria.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		criteria.add(Restrictions.idEq(id));
		return (Message)criteria.uniqueResult();
	}
}