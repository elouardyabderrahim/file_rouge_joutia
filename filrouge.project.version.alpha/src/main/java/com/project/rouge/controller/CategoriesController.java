package com.project.rouge.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rouge.model.Category;
import com.project.rouge.service.CategoriesService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoriesController {
	
			  @Autowired
			  private CategoriesService categorieService;
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/category")    
			  public List<Category> getAllCategories() {
			    return categorieService.getAllCategories();
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/category/{id}")
			  public Optional<Category> getCategorieById(@PathVariable("id") Long id) {
					return categorieService.getCategorie(id);
				}
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PostMapping("/category")
			  public Category createCategorie( @RequestBody Category categorie) {
			    return categorieService.saveCategories(categorie);
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PutMapping("/category/{id}")
			  public ResponseEntity<Category> updateCategories(@PathVariable("id") long id, @RequestBody Category categorie) {
					return new ResponseEntity<Category>(categorieService.updateCategorie(categorie, id), HttpStatus.OK);
				}

			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @DeleteMapping("/category/{id}")
			  public ResponseEntity<String> deletCategorie(@PathVariable Long id) {
					try {
						categorieService.deleteCategories(id);
						return new ResponseEntity<String>(HttpStatus.OK);
					} catch (RuntimeException ex) {
						// log the error message
						System.out.println(ex.getMessage());
						return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
					}
				}
			  
			  
			  
			  

}