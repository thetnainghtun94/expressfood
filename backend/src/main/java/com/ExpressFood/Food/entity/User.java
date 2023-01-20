package com.ExpressFood.Food.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.ToString;

@Entity
@ToString
@Table(name = "users")
public class User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(length = 30,nullable = false)
	@NotBlank(message = "Required")
	private String name;
	
	@Column(length = 100,nullable = false)
	@NotBlank(message = "Required")
	private String password;
	
	@Column(length = 100, nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String email;
	
	@Column(columnDefinition = "ENUM('admin','user')NOT NULL")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;
	
	public User() {
		
	}
	
	public User(String name, String email, Role role, String password) {	
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User(Integer id, @NotBlank(message = "Required") String name,
			@NotBlank(message = "Required") String password, @NotBlank(message = "Required") String email, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Role getRole() {
		return role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
	
	
	
	
	
	

}
