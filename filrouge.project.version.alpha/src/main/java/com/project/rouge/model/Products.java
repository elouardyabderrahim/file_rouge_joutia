package com.project.rouge.model;


import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, 
        property = "id")
@Embeddable
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Products  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double currentPrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private String photoName;
    @Transient
    private int quantity=1;
   
    @ManyToOne
    private  Category category;
    @OneToMany(mappedBy = "product")
    private Collection<OrderItem> orderItem;
}


//	@JsonBackReference
//	@ManyToOne @JoinColumn(name="category_Id", nullable=false)
//	    private Categories category;

	 
//	 @JsonBackReference
//	@ManyToOne @JoinColumn(name="order_id", nullable=false)
//	    private Order order;

	 
	 
	 
//		@ManyToOne(targetEntity = Categories.class, fetch = FetchType.LAZY)
//		@JoinColumn(name = "category_Id", insertable = false, updatable = false)
		
		
		
		
//		@ManyToOne  
//	    @JoinTable( name = "T_category_product_Associations",
//	                joinColumns = @JoinColumn( name = "product_id" ),
//	                inverseJoinColumns = @JoinColumn( name = "category_id" ) )
	 
	 
//		@ManyToOne
//	 @JoinTable( name = "T_order_product_Associations",
//             joinColumns = @JoinColumn( name = "product_id" ),
//             inverseJoinColumns = @JoinColumn( name = "order_id" ) )
	
	

