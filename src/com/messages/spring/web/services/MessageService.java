package com.messages.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messages.spring.web.dao.Message;
import com.messages.spring.web.dao.MessageDao;

@Service("messageService")
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	
	
	public boolean delete(int id){
		return messageDao.delete(id);
	}
	
	public void saveOrUpdate(Message message){
		messageDao.saveOrUpdate(message);
	}
	
	public List<Message> getMessages(){
		return messageDao.getMessages();
	}
	
	public Message getMessage(int id){
		return messageDao.getMessage(id);
	}
}
