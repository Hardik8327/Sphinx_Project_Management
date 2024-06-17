package com.example.License.License_Backend.Entity;

import java.util.List;

import com.example.License.License_Backend.Entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Admin {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String name;
	private String password;
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<User> user;
	protected Admin() {}
	public Admin(int id, String username, String name, String password) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
