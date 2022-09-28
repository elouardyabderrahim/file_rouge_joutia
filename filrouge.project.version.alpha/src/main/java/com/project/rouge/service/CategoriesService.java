package com.project.rouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.project.rouge.model.Category;
import com.project.rouge.repository.CategoriesRepository;

@Service
public class CategoriesService {
	 @Autowired
	    private CategoriesRepository categoriesRepository;

	    public Optional<Category> getCategorie(final Long id) {
	        return categoriesRepository.findById(id);
	    }

	    public Iterable<Category> getCategories() {
	        return categoriesRepository.findAll();
	    }

	    public void deleteCategories(final Long category_id) {
	    	categoriesRepository.deleteById(category_id);
	    }

	    public Category saveCategories(Category category) {
	    	Category savedCategories = categoriesRepository.save(category);
	        return savedCategories;
	    }
	    public  List<Category> getAllCategories(){
	    	return categoriesRepository.findAll();
	      }

	  
	    public Category updateCategorie(Category categorie, long category_id) {
			
			Category existingCategorie = categoriesRepository.findById(category_id)
					.orElseThrow();//-> new Exeption("Categories", "category_id", category_id));


			existingCategorie.setName(categorie.getName());
			existingCategorie.setPhoto(categorie.getPhoto());
//			existingCategorie.setProducts(categorie.getProducts());
		
			

			categoriesRepository.save(existingCategorie);

			return existingCategorie;
			
		}

		

			       
				    
				   
		
		}

		

