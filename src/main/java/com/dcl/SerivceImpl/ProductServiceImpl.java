package com.dcl.SerivceImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.Entity.Product;
import com.dcl.ProductDto.ProductDto;
import com.dcl.ProductRepo.ProductRepo;
import com.dcl.Request.AddProduct;
import com.dcl.Request.UpdateRequest;
import com.dcl.Service.ProductService;
@Service	
public class ProductServiceImpl implements ProductService  {
	@Autowired
	private ProductRepo prepo;
	
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public ProductDto addProduct(AddProduct request) {

//	    Product p = new Product();
//
//	    p.setProductName(request.getProductName());
//	    p.setPrice(request.getPrice());
//	    p.setBrand(request.getBrand());

		Product p = mapper.map(request, Product.class);
	    p = prepo.save(p);

//	    ProductDto dto = new ProductDto();
//	    dto.setProductId(p.getProductId());
//	    dto.setProductName(p.getProductName());
//	    dto.setPrice(p.getPrice());
//	    dto.setBrand(p.getBrand());
	    
	    ProductDto dto = mapper.map(p, ProductDto.class);

	    return dto;
	}

	@Override
	public ProductDto getProductById(Integer productid) {
	  Product p = prepo.findById(productid).orElse(null);
	  if(p==null) {
		  throw new RuntimeException("not found!");
	  }
	  
	  return mapper.map(p, ProductDto.class);
//	  ProductDto dto = new ProductDto();
//	    dto.setProductId(p.getProductId());
//	    dto.setProductName(p.getProductName());
//	    dto.setPrice(p.getPrice());
//	    dto.setBrand(p.getBrand());
//
//	    return dto;
	}

	@Override
	public List<ProductDto> getAllProduct() {

List<Product>  productList= prepo.findAll();
		
		Function<Product, ProductDto> functional=(p)->{
//			ProductDto pdto=new ProductDto();
//			pdto.setBrand(p.getBrand());
//			pdto.setPrice(p.getPrice());
//			pdto.setProductName(p.getProductName());
//			pdto.setProductId(p.getProductId());
//			return pdto;
			  return mapper.map(p, ProductDto.class);
		};
		
   List<ProductDto>	pdtoList=productList.stream()
		   .map(functional)
		   .collect(Collectors.toList());
		return pdtoList ;
	}

	@Override
	public void deleteProductById(Integer productId) {
		Product p =prepo.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
		prepo.deleteById(productId);
	}

	@Override
	public ProductDto updateProduct(Integer productId, UpdateRequest request) {
		Product extistingProduct=prepo.findById(productId).orElseThrow(()->new RuntimeException("product not found"));
//		extistingProduct.setProductName(request.getProductName());
//		extistingProduct.setPrice(request.getPrice());
//		extistingProduct.setBrand(request.getBrand());
		mapper.map(request,extistingProduct);
		Product p=prepo.save(extistingProduct);
		
//		ProductDto dto=new ProductDto();
//		dto.setBrand(p.getBrand());
//		dto.setPrice(p.getPrice());
//		dto.setProductName(p.getProductName());
//		dto.setProductId(p.getProductId());
//		
//		return dto;
		
		return mapper.map(p, ProductDto.class);
	}
}
