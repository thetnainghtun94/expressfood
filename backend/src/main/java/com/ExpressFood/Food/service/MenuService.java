package com.ExpressFood.Food.service;


import java.util.List;


import com.ExpressFood.Food.dto.MenuDto;
import com.ExpressFood.Food.entity.Category;
import com.ExpressFood.Food.entity.Menu;
import com.ExpressFood.Food.exceptions.MenuNotExistException;



public interface MenuService {
	
	public List<MenuDto> listMenus();
	
	public MenuDto getDtoFromMenu(Menu menu);
	 
	public Menu getMenuFromDto(MenuDto menuDto, Category category) ;
	 
	public void addMenu(MenuDto menuDto, Category category) ;
	 
	public Menu getMenuById(Integer menuId) throws MenuNotExistException;

	public void updateMenu(Integer menuID, MenuDto menuDto, Category category);

	//for cart
	public static Menu findById(Integer menuId) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
	
	 
	
	
	

}
