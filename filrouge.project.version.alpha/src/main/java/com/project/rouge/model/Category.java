package com.project.rouge.model;

import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "category_id")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, 
        property = "id")
public class Category  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
   
    @OneToMany(mappedBy = "category")
    private Collection<Products> products;
}
	
	
	
	
	//	@OneToMany
//    @JoinTable( name = "T_category_product_Associations",
//                joinColumns = @JoinColumn( name = "category_id" ),
//                inverseJoinColumns = @JoinColumn( name = "product_id" ) )
	
	
	

	
	
	
	
	
	
	
	
	//	 @OneToMany( targetEntity=Products.class, mappedBy="categories" )//(mappedBy = "categories",cascade = CascadeType.ALL)
//	 private Set<Products> products;
//	private Collection<Products> products= new ArrayList<>();
	
	
	


