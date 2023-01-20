package com.ExpressFood.Food.entity;

import com.ExpressFood.Food.dto.MenuDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private @NotNull String name;
    private @NotNull String image;
    private @NotNull double price;
    private @NotNull String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryid", nullable = false)
    Category category;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    private List<WishList> wishListList;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private List<Cart> carts;

    public Menu(MenuDto menuDto, Category category) {
        this.name = menuDto.getName();
        this.image = menuDto.getImage();
        this.description = menuDto.getDescription();
        this.price = menuDto.getPrice();
        this.category = category;
    }

    public Menu(String name, String image, double price, String description, Category category) {
        super();
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", description="
				+ description + ", category=" + category + ", carts=" + carts + "]";
	}
    
    
//    @Override
//    public String toString() {
//        return "Menu{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", image='" + image + '\'' +
//                ", price=" + price +
//                ", description='" + description + '\'' +
//                '}';
//    }
}

//package com.ExpressFood.Food.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotBlank;
//
//import com.ExpressFood.Food.dto.MenuDto;
//
//@Entity
//public class Menu {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer menu_id;
//	
//	@Column(length = 50)
//	@NotBlank(message = "Required")
//	private String name;
//	
//	@Column(length = 1000)
//	@NotBlank(message = "Required")
//	private String image;
//	
//	private double price;
//	
//	@Column(length = 1000)
//	@NotBlank(message = "Required")
//	private String description;
//	
//	@ManyToOne
//	@JoinColumn(name="id",referencedColumnName="id",nullable=false)
//	Category category;
//
//	public Menu() {
//		
//	}
//	public Menu(Integer menu_id, @NotBlank(message = "Required") String name,
//			@NotBlank(message = "Required") String image, @NotBlank(message = "Required") double price,
//			@NotBlank(message = "Required") String description, Category category) {
//		super();
//		this.menu_id = menu_id;
//		this.name = name;
//		this.image = image;
//		this.price = price;
//		this.description = description;
//		this.category = category;
//	}
//	
//	public Menu(MenuDto menuDto,Category category) {
//		System.out.println(menuDto);
//		this.name = menuDto.getName();
//		this.image = menuDto.getImage();
//		this.description = menuDto.getDescription();
//		this.price = menuDto.getPrice();
//		this.category = category;
//		System.out.println(this);
//	}
//
//	public Integer getMenu_id() {
//		return menu_id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setMenu_id(Integer menu_id) {
//		this.menu_id = menu_id;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}	
//}
