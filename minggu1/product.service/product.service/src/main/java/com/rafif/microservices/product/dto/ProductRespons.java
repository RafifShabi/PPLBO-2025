package com.rafif.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRespons(String id, String name, String description, BigDecimal price) {
    
}
