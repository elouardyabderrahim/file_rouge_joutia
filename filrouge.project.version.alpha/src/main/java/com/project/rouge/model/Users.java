package com.project.rouge.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
//@Inheritance(strategy=InheritanceType.JOINED)//three enheritanceType: joined,Table_per_class,Single_Table
@Table(name="users")
public class Users {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Column
	private String firstname;
	@Column
	private String lastName;
	@Column
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	private String password;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String telephone;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Roles> appRoles = new ArrayList<>() ;

	  @ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "user_order", 
	        joinColumns = { @JoinColumn(name = "user_Id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "order_Id") }
	    )
	  List<Order> orders = new ArrayList<>();

}*/
