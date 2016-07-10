package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping(value = "/product")
public class ProductController {
	
	
	 @Autowired
	  private ProductRepository repo;

	@RequestMapping(method=RequestMethod.GET)
	  public List<Product> getAll() {
		    return (List<Product>) repo.findAll();
	  }
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	  public @ResponseBody Product getOne(@PathVariable Integer id) {
		    return repo.findOne(id);
	  }
	  
	  @RequestMapping(method=RequestMethod.POST)
	  public Product create(@RequestBody Product product) {
		  return repo.save(product);
	  }
	  
	  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	  public @ResponseBody void delete(@PathVariable Integer id) {
		  repo.delete(id);
	  }
	  
	  @RequestMapping(value="/{id}", method=RequestMethod.PUT)
	  public Product update(@PathVariable Integer id, @RequestBody Product product) {
		  Product updateProduct = repo.findOne(id);
		  updateProduct.setName(product.getName());
		  updateProduct.setDetails(product.getDetails());
		  updateProduct.setPrice(product.getPrice());
		  
		  return this.repo.save(updateProduct);
	  }

	}