package com.example.License.License_Backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class License {
	@JsonIgnore
	 @ManyToOne
	    @JoinColumn(name = "user_id")
	private User user;
	@Id
	@GeneratedValue
	private int lId;
	private String lName;
	private int price;
	private String descp;
	protected License() {}
	public License(int lId, String lName, int price, String descp) {
		super();
		this.lId = lId;
		this.lName = lName;
		this.price = price;
		this.descp = descp;
	}
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return descp;
	}
	public void setDesc(String descp) {
		this.descp = descp;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
return "License [ lId=" + lId + ", lName=" + lName + ", price=" + price + ", descp=" + descp+ "]";
	}


	
}
