package com.project.rouge;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


import com.project.rouge.model.Category;
import com.project.rouge.model.Products;
import com.project.rouge.service.CategoriesService;
import com.project.rouge.service.ProductsService;

import net.bytebuddy.utility.RandomString;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;



//import com.project.rouge.model.Roles;
//import com.project.rouge.model.Users;
//import com.project.rouge.service.AccountService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Autowired
	private ProductsService producSevice;
	@Autowired
	private CategoriesService categorieSevice;



//@Autowired
//private RepositoryRestConfiguration repositoryRestConfiguration;


@Override

//    repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);

	public void run(String... args) throws Exception {
// repositoryRestConfiguration.exposeIdsFor(Products.class,Categories.class); si tu napas l id tu demende a json de la expose

		 	categorieSevice.saveCategories(new Category(null,"Computers",null,null));
		 	categorieSevice.saveCategories(new Category(null,"Printers",null,null));
		 	categorieSevice.saveCategories(new Category(null,"Smart phones",null,null));
		 	categorieSevice.saveCategories(new Category(null,"clothes",null,null));
		 	
	        Random rnd=new Random();
	        categorieSevice.getAllCategories().forEach(c->{
	        	
	        	
	        		  Products p=new Products();
	                p.setName(RandomString.make(18));
	                p.setCurrentPrice(100+rnd.nextInt(10000));
	                p.setAvailable(rnd.nextBoolean());
	                p.setDescription(RandomString.make(18));
	                p.setSelected(rnd.nextBoolean());
	                p.setCategory(c);
	                p.setPhotoName("unknown.png");
	                producSevice.saveProducts(p); 
	        	
	        	    
	        });
	        

}
}
	                
	                
//	                p.setName("itEnds with us");
//	                p.setCurrentPrice(99);
//	                p.setAvailable(true);
//	                p.setDescription("Lorem abosem gjfkd kdkkcvnn fdkk");
//	                p.setSelected(false);
//	                p.setCategory(c);
//	                p.setPhotoName("unknown.png");
//	                producSevice.saveProducts(p);
	          
	        

	 
//	
	
//	Random rnd= new Random();
//	@Override
//	public void run(String... args) throws Exception {
//		
//		categorieSevice.saveCategories(new Categories(null,"handmade",null));
//		categorieSevice.getAllCategories().forEach(c->{
//			Products p=new Products();
//			p.setProduct_name(RandomString.make(18));
//			p.setPrice(10+rnd.nextInt(300));
//		
//			producSevice.saveProducts(p);
			
			
			
//		});
		
		
	
	
