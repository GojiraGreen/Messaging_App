package com.messages.spring.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	@NotBlank(groups={FormGroup.class, HibernateGroup.class})
	@Size(min = 8, max = 15, message="Must be between 8 and 15 characters", groups={FormGroup.class, HibernateGroup.class})
	@Pattern(regexp = "^\\w{8,}$", message="Username cannot contain spaces", groups={FormGroup.class, HibernateGroup.class})
	@Id
	@Column(name="username")
	private String username;

	@NotBlank(groups={FormGroup.class, HibernateGroup.class})
	@Email(groups={FormGroup.class, HibernateGroup.class})
	private String email;

	@NotBlank(groups={FormGroup.class, HibernateGroup.class})
	@Pattern(regexp = "^\\S+$", message="Password cannot contain spaces", groups={FormGroup.class, HibernateGroup.class})
	@Size(min = 8, max = 15,groups=FormGroup.class)
	private String password;
	
	private boolean enabled;
	
	private String authority;

	/**
	 * Empty contructor
	 */
	public User() {

	}

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param email
	 * @param password
	 * @param enabled
	 * @param authority
	 */
	public User(String username, String email, String password, boolean enabled, String authority) {

		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", authority=" + authority + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
