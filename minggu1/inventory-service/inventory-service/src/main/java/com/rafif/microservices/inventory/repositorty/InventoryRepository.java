package com.rafif.microservices.inventory.repositorty;

import com.rafif.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
      boolean existsBySkuCodeAndQuantityIsGreaterThanEqualIs(String skuCode, Integer quantity);
}
