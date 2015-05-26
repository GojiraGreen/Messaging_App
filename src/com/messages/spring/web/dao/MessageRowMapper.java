package com.messages.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageRowMapper implements RowMapper<Message>{

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();						
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		
		message.setId(rs.getInt("id"));
		message.setUser(user);
		message.setText(rs.getString("text"));

		return message;
	}
}
