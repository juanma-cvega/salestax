package com.mycompany.salestax.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.salestax.beans.Product;
import com.mycompany.salestax.services.ProductService;

@Component
@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	private final static Logger LOG = LoggerFactory.getLogger(ProductResource.class);
	
	@Autowired
	private ProductService service;
	
	@GET
	public List<Product> getProducts() {
		List<Product> list = service.list();
		LOG.debug("Products list: " + list.toString());
		return list;
	}
}
