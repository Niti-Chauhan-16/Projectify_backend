package com.Projectify.first.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Component
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	private String username;
	
	@Column
	@JsonIgnore
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	

	@Column
	private String email;
	
	@Column
	private String name;
	
	@Column
	private int phone;
	
	

	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable( name="User_Role_Table",
	       joinColumns= {
	    		   @JoinColumn(name="User_Id",referencedColumnName="id")
	       },
	       inverseJoinColumns= {
	    		   @JoinColumn(name="Role_Id",referencedColumnName="id")
	       }
	)
	private Set<Role> roles;
	
	public void setRoles(Set<Role> roles) {
		this.roles=roles;
		
	}
	
	public Set<Role> getRoles(){	
		return this.roles;
	}
	
	
	
	
	
}
