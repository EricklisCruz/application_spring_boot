package com.projetodeestudo.course.controllers;

import com.projetodeestudo.course.models.entities.Product;
import com.projetodeestudo.course.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findProductById() {
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok().body(product);
    }
}
