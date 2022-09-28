package com.project.rouge.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roleName;
}



//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable( name = "users_roles",  joinColumns = @JoinColumn( name
//	= "role_id" ), inverseJoinColumns = @JoinColumn( name = "user_id" ))
//    private Collection<Users> users = new ArrayList<>();

    
    
	
    
    