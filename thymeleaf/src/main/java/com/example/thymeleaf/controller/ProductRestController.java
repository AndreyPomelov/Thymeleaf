package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.entity.Product;
import com.example.thymeleaf.model.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/rest/products")
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productRepository.findById(id).orElseGet(Product::new);
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        product.setId(0L);
        return productRepository.save(product);
    }

    @PostMapping("/update")
    public Product addOrUpdate(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        productRepository.delete(productRepository.getById(id));
        return HttpStatus.OK.value();
    }
}
