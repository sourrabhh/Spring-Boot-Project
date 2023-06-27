package com.app.ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ecommerce.DTO.ProductDto;
import com.app.ecommerce.Model.Category;
import com.app.ecommerce.Model.Product;
import com.app.ecommerce.Repository.ProductRepository;

@Service
public class ProductService 
{
    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDto productDto, Category category) 
    {
        Product product = new Product();

        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setImgURL(productDto.getImgURL());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        productRepository.save(product);
    }
}
