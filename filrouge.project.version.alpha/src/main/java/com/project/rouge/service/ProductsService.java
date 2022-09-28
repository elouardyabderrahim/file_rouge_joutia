package com.project.rouge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.rouge.model.Category;
import com.project.rouge.model.Products;
import com.project.rouge.repository.ProductsRepository;






@Service 
public class  ProductsService {
	 @Autowired
	    private ProductsRepository productsRepository;

	    public Optional<Products> getProduct(final Long id) {
	        return productsRepository.findById(id);
	    }

	    public Iterable<Products> getProducts() {
	        return productsRepository.findAll();
	    }

	    public void deleteProducts(final Long id) {
	    	productsRepository.deleteById(id);
	    }

	    public Products saveProducts(Products products) {
	    	Products savedProducts = productsRepository.save(products);
	        return savedProducts;
	    }
	    public  List<Products> getAllProducts(){
	    	return productsRepository.findAll();
	      }

	  
	    public Products updateCategorie(Products products, long id) {
			
			Products existingProduct = productsRepository.findById(id)
					.orElseThrow();//-> new Exeption("Products", "category_id", category_id));

			existingProduct.setName(products.getName());
			existingProduct.setCurrentPrice(products.getCurrentPrice());
			existingProduct.setDescription(products.getDescription());

			existingProduct.setDescription(products.getDescription());
			existingProduct.setPhotoName(products.getPhotoName());
			 
//			existingProduct.setAvailable(product.isAvailable());
			
		

		
			

			productsRepository.save(existingProduct);

			return existingProduct;
			
		}
	    
	    public List<Products> findByCategoryId(Category id) {
	        return productsRepository.findByCategoryId(id);
	    }

}

		
