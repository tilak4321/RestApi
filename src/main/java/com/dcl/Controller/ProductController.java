package com.dcl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.Entity.Product;
import com.dcl.ProductDto.ProductDto;
import com.dcl.Request.AddProduct;
import com.dcl.Request.UpdateRequest;
import com.dcl.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	 @Autowired
	    private ProductService productService;

	    @PostMapping("/add")
	    public ProductDto addProduct(@RequestBody AddProduct request) {
	        return productService.addProduct(request);
	    }

	    @GetMapping("/get/{ProductId}")
	    public ProductDto getProductById(@PathVariable Integer ProductId) {
	    	return productService.getProductById(ProductId);
		
	    	
	    }
	    
	    
	    @GetMapping("/all")
	    public List<ProductDto> getAllProduct() {
	        return productService.getAllProduct();     
	    }
	    
	    @DeleteMapping("/delete/{ProductId}")
	    public ResponseEntity<?> deleteProductById( @PathVariable Integer ProductId ){
	    	
	    	productService.deleteProductById(ProductId);
	    	return ResponseEntity.ok("product deleted");
	    }
	    @PutMapping("/update/{ProductId}")
	    public ResponseEntity<?> updateProduct(@PathVariable Integer ProductId,@RequestBody UpdateRequest request){
	    	productService.updateProduct(ProductId, request);
	    	return ResponseEntity.ok("product updated sussfully");
	    	
	    }
}
