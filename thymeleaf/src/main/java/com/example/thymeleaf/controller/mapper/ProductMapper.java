package com.example.thymeleaf.controller.mapper;

import com.example.thymeleaf.controller.dto.ProductDTO;
import com.example.thymeleaf.model.entity.Product;
import org.springframework.stereotype.Component;

/** Класс, предназначенный для маппинга ProductDTO в Product и наоборот
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 * @see Product
 * @see ProductDTO
 */
@Component
public class ProductMapper {

    public Product toProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public ProductDTO fromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
