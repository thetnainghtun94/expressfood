package com.ExpressFood.Food.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ExpressFood.Food.common.ApiResponse;
import com.ExpressFood.Food.dto.MenuDto;
import com.ExpressFood.Food.entity.Category;
import com.ExpressFood.Food.service.CategoryService;
import com.ExpressFood.Food.service.MenuService;


@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	CategoryService categoryService;
	
//	@Autowired
//	StorageService storageService;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addMenu(@RequestBody MenuDto menuDto){
		System.out.println(menuDto);
		Optional<Category> optionalCategory= categoryService.readCategory(menuDto.getCategoryId());
		 if (!optionalCategory.isPresent()) {
			 return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
		 }
		 Category category = optionalCategory.get();
		 menuService.addMenu(menuDto, category);
		  return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Menu has been added"), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<MenuDto>> getMenus(){
		List<MenuDto> body = menuService.listMenus();
		return new ResponseEntity<List<MenuDto>>(body, HttpStatus.OK);		
	}
	
	@PostMapping("/update/{menuID}")
	public ResponseEntity<ApiResponse>updateMenu(@PathVariable("menuID") Integer menuID,
			@RequestBody @Valid MenuDto menuDto){
		Optional<Category> optionalCategory= categoryService.readCategory(menuDto.getCategoryId());
		 if (!optionalCategory.isPresent()) {
			 return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);	 
		 }
		 Category category = optionalCategory.get();
		 menuService.updateMenu(menuID,menuDto, category); 
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Menu has been updated"), HttpStatus.OK);
	}
	
}
