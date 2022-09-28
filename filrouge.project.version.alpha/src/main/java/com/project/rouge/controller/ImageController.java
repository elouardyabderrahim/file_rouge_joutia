package com.project.rouge.controller;

import org.springframework.http.MediaType;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.rouge.model.Products;
import com.project.rouge.service.ProductsService;

@CrossOrigin("*")
@RestController
public class ImageController {
	
	@Autowired
	private ProductsService productService;

	    
	    
	    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	        Products p= productService.getProduct(id).get();
	        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Desktop/file rouge/e-com/product/"+p.getPhotoName()));
	    }
	    @PostMapping(path = "/uploadPhoto/{id}")
	    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
	       Products p= productService.getProduct(id).get();
	       p.setPhotoName(file.getOriginalFilename());
	       Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
	       productService.saveProducts(p);
	    }
	}


