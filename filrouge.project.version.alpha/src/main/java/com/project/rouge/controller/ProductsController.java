package com.project.rouge.controller;







import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.project.rouge.model.Products;
import com.project.rouge.service.ProductsService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductsController {
	
			  @Autowired
			  private ProductsService productService;
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/products")    
			  public List<Products> getAllProducts() {
			    return productService.getAllProducts();
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/products/{product_id}")
			  public Optional<Products> getProductById(@PathVariable("product_id") Long product_id) {
					return productService.getProduct(product_id);
				}
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PostMapping("/products")
			  public Products createCategorie( @RequestBody Products products) {
			    return productService.saveProducts(products);
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PutMapping("/products/{product_id}")
			  public ResponseEntity<Products> updateProducts(@PathVariable("product_id") long product_id, @RequestBody Products products) {
					return new ResponseEntity<Products>(productService.updateCategorie(products , product_id), HttpStatus.OK);
				}

			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @DeleteMapping("/products/{product_id}")
			  public ResponseEntity<String> deletCategorie(@PathVariable Long product_id) {
					try {
						productService.deleteProducts(product_id);
						return new ResponseEntity<String>(HttpStatus.OK);
					} catch (RuntimeException ex) {
						// log the error message
						System.out.println(ex.getMessage());
						return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
					}
				}
			  
			  @GetMapping("/products/search/findByCategory/{id}")    
			  public List<Products> findByCategoryId(@PathVariable Category id) {
			    return productService.findByCategoryId(id);
			  }
			  
			  
			  
			  

}
