package com.ExpressFood.Food.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private Menu menu;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private int quantity;

    public Cart() {
    }

	public Cart(Integer id, LocalDate createdDate, Menu menu, User user, int quantity) {
		
		this.createdDate = createdDate;
		this.menu = menu;
		this.user = user;
		this.quantity = quantity;
	}

	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    

    

   
}
//@Entity
//public class Cart {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer cart_id;
//	
//	@ManyToOne
//	@JoinColumn(name = "menu_id")
//	private Menu menu;
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	private int quantity;
//	
//	@Column(name = "created_date")
//	private Date createdDate;
//	
//	public Cart() {
//		
//	}
//
//	public Cart(Integer cart_id, Menu menu, User user, int quantity, Date createdDate) {
//		super();
//		this.cart_id = cart_id;
//		this.menu = menu;
//		this.user = user;
//		this.quantity = quantity;
//		this.createdDate = createdDate;
//	}
//
//	public Integer getCart_id() {
//		return cart_id;
//	}
//
//	public Menu getMenu() {
//		return menu;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCart_id(Integer cart_id) {
//		this.cart_id = cart_id;
//	}
//
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	@Override
//	public String toString() {
//		return "Cart [cart_id=" + cart_id + ", menu=" + menu + ", user=" + user + ", quantity=" + quantity
//				+ ", createdDate=" + createdDate + "]";
//	}
//
//	//for date
//	public void setCreatedDate(java.util.Date date) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
