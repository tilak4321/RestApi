package com.dcl.Service;


import java.util.List;

import com.dcl.Entity.Product;
import com.dcl.ProductDto.ProductDto;
import com.dcl.Request.AddProduct;
import com.dcl.Request.UpdateRequest;

public interface ProductService {

    ProductDto addProduct(AddProduct request);

    ProductDto getProductById(Integer productId);

    List<ProductDto> getAllProduct(); 
    
    void deleteProductById(Integer productId);
    
    ProductDto updateProduct(Integer productId,UpdateRequest request);

}   