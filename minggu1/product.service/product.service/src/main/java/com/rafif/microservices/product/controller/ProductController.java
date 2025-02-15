package com.rafif.microservices.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafif.microservices.product.dto.ProductRequest;
import com.rafif.microservices.product.dto.ProductRespons;
// import com.rafif.microservices.product.model.Product;
import com.rafif.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductRespons createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
        
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductRespons> getAllProducts() {
        return productService.getAllProducts();
    }
}
