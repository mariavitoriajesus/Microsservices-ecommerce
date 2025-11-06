package com.storefront.client;

import com.storefront.dto.InventoryResponse;
import com.storefront.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "warehouse", url = "http://localhost:8081")
public interface WharehouseClient {
    @GetMapping("/products")
    List<ProductDTO> getAllProducts();

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);

    @GetMapping("inventories/{productId}")
    InventoryResponse getInventoryByProductId(@PathVariable("productId") String productId);

    @PutMapping("/reduce/{productId}/{quantity}")
    void reduceStock(@PathVariable("productId") String productId, @PathVariable("quantity") Integer quantity);

}
