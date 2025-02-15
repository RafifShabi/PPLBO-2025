package com.rafif.microservices.product.service;

import org.springframework.stereotype.Service;
import com.rafif.microservices.product.dto.ProductRequest;
import com.rafif.microservices.product.dto.ProductRespons;
import com.rafif.microservices.product.model.Product;
import com.rafif.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductRespons createProduct(ProductRequest productRequest) {
        Product product = (Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build());
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductRespons(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductRespons> getAllProducts() {
        return productRepository.findAll()
            .stream()
            .map(product -> new ProductRespons(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
            .toList();
    }

}
