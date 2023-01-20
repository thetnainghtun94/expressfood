package com.ExpressFood.Food.controller;

import java.util.List;

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
import com.ExpressFood.Food.entity.Category;
import com.ExpressFood.Food.service.CategoryService;
import com.ExpressFood.Food.utils.Helper;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
//	@Autowired
//	StorageService storageService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		if(Helper.notNull(categoryService.readCategory(category.getCategoryName()))){
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);	
	}
	
//	@PostMapping("/file/create") 
//	public ResponseEntity<String> createFile(
//			@RequestParam("file") MultipartFile file, //song , photo,
//			@RequestParam("fileType") String fileType
//	) {
//		String filePath = storageService.create(file, fileType);
//		if (filePath == null) {
//			return ResponseEntity.internalServerError().build();
//		}
//		return ResponseEntity.ok(filePath);
//	}
//
//	@PutMapping("/file/update")
//	public ResponseEntity<String> updateFile(
//			@RequestParam("file") MultipartFile file,
//			@RequestParam("fileType") String fileType,
//			@RequestParam("filePath") String filePath
//	) {
//		String newFilePath = storageService.update(file, fileType, filePath);
//		if (newFilePath == null) {
//			return ResponseEntity.internalServerError().build();
//		}
//		return ResponseEntity.ok(newFilePath);
//	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> body = categoryService.listCategory();
		return new ResponseEntity<List<Category>>(body,HttpStatus.OK);
	}
	
	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID,
			@Valid @RequestBody Category category){
		if(Helper.notNull(categoryService.readCategory(categoryID))) {
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
			
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);	
	}
	
//	@GetMapping("/category/{id}")
//	public ResponseEntity<Category> getCategory(@PathVariable("id") int id) {
//		Category category = categoryService.get(id);
//		if(category == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(category);
//	}
	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Category>  updateCategory(@PathVariable int id,@RequestBody Category updateCategory) {
//		Category updatedCategory = categoryService.updateCategory(id, updateCategory);
//		if(updatedCategory == null) {
//			return ResponseEntity.notFound().build();
//		}
//		return ResponseEntity.ok().body(updatedCategory);		
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?>deleteCategory(@PathVariable int id){
//		Category category = categoryService.get(id);
//		if(category == null) {
//			return ResponseEntity.notFound().build();
//		}
//		boolean isDeleted = categoryService.delete(id);
//		if (!isDeleted) {
//		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//		}
//		return ResponseEntity.ok().build();
//		
//	}

}
