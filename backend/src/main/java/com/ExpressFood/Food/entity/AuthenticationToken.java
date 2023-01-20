package com.ExpressFood.Food.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AuthenticationToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String token;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name="user_id")
	private User user;
	
	public AuthenticationToken() {
		
	}

	public AuthenticationToken(Integer id, String token, Date createdDate, User user) {
		super();
		this.id = id;
		this.token = token;
		this.createdDate = createdDate;
		this.user = user;
	}

	public AuthenticationToken(User user) {
		// TODO Auto-generated constructor stu
		this.user = user;
		this.createdDate = new Date();
		this.token = UUID.randomUUID().toString();
	}

	public Integer getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
