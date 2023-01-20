package com.ExpressFood.Food.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExpressFood.Food.dto.MenuDto;
import com.ExpressFood.Food.entity.Category;
import com.ExpressFood.Food.entity.Menu;
import com.ExpressFood.Food.exceptions.MenuNotExistException;
import com.ExpressFood.Food.repository.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	MenuRepo menuRepo;

	@Override
	public List<MenuDto> listMenus() {
		List<Menu> menus = menuRepo.findAll();
		List<MenuDto> menuDtos = new ArrayList<>();
		for(Menu menu:menus) {
			MenuDto menuDto = getDtoFromMenu(menu);
			menuDtos.add(menuDto);
		}
		return menuDtos;
	}

	@Override
	public MenuDto getDtoFromMenu(Menu menu) {
		MenuDto menuDto = new MenuDto(menu);
		return menuDto;
	}

	@Override
	public Menu getMenuFromDto(MenuDto menuDto, Category category) {
		Menu menu = new Menu(menuDto,category);
		return menu;
	}

	@Override
	public void addMenu(MenuDto menuDto, Category category) {
		Menu menu = new Menu(menuDto,category);
		menuRepo.save(menu);
		
	}

	@Override
	public void updateMenu(Integer menuID, MenuDto menuDto, Category category) {
		Menu menu = getMenuFromDto(menuDto,category);
		menu.setId(menuID);
		menuRepo.save(menu);
	}
 
	@Override
	public Menu getMenuById(Integer menuId) throws MenuNotExistException{
		Optional<Menu> optionalMenu = menuRepo.findById(menuId);
		if(!optionalMenu.isPresent())
		throw new MenuNotExistException("Menu is is invalid"+ menuId);
		return optionalMenu.get();
	}
	
	
	//for AddToCart service
	public Menu findById(Integer menuId) throws MenuNotExistException{
		Optional<Menu> optionalMenu= menuRepo.findById(menuId);
		if(optionalMenu.isEmpty()) {
			throw new MenuNotExistException("menu id is invalid:"+menuId);
		}
		return optionalMenu.get();
	}

}
