package com.example;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@Entity
public class Product {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String details;
    private Integer price;
    

	protected Product() {}
    
    public Product(String name, String details, Integer price) {
		this.name = name;
		this.details = details;
		this.price = price;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	 @Override

	 public String toString() {

	  return "[id=" + id + ", name=" + name

	    + ", details=" + details + ", price="

	    + price + "]";

	 }


}
