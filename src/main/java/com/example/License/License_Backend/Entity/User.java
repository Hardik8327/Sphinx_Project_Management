package com.example.License.License_Backend.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "my_user_table")
public class User {
	@Id
	@GeneratedValue
private int id;
	@ManyToOne
    @JoinColumn(name = "admin_id")
	@JsonIgnore
private Admin admin;
private String username;
private String password;
private String name;
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<License> licenses;

protected User() {}

public User(int id, String username, String password, String name) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.name = name;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<License> getLicenses() {
    return licenses;
}
public void setLicenses(List<License> licenses) {
	this.licenses = licenses;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name +"]";
}


}
