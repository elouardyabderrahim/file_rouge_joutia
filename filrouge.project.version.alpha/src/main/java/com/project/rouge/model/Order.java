package com.project.rouge.model;

import java.util.Collection;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
//@Data @NoArgsConstructor @AllArgsConstructor
//@Table(name="orders")
//public class Orders {
//	
//	@Id
//	@Column
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long order_id;
//	
//	private int quantity;
//
//
//	
//	
//	@JsonBackReference
//	@OneToMany(targetEntity=Products.class,mappedBy = "order")
//	private List<Products> products = new ArrayList<>();
@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, 
        property = "id")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "order")
    private Collection<OrderItem> orderItems;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    private double totalAmount;
    @OneToOne
    private Payment payment;


}
	
	
//	 @OneToMany
//	 @JoinTable( name = "T_order_product_Associations",
//            joinColumns = @JoinColumn( name = "order_id" ),
//            inverseJoinColumns = @JoinColumn( name = "product_id" ) )

