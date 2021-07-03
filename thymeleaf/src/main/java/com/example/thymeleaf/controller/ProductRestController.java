package com.example.thymeleaf.controller;

import com.example.thymeleaf.controller.dto.ProductDTO;
import com.example.thymeleaf.controller.mapper.ProductMapper;
import com.example.thymeleaf.exception.TestException;
import com.example.thymeleaf.model.entity.Product;
import com.example.thymeleaf.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

/** REST-контроллер
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@RequiredArgsConstructor
@RequestMapping("/rest/products")
@RestController
public class ProductRestController {

    /** Ссылка на репозиторий */
    private final ProductRepository productRepository;
    /** Ссылка на маппер */
    private final ProductMapper productMapper;

    /** Метод, возвращающий продукт по ID
     *
     * @param id - ID продукта
     * @return - возвращаемый DTO продукта
     */
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        // Бросаем тестовый эксепшен при некоторых условиях
        // в демонстрационных целях.
        if (id == 100) throw new TestException();
        return productMapper.fromProduct(productRepository.findById(id).orElseGet(Product::new));
    }

    /** Метод, возвращающий все продукты из БД
     *
     * @return - полный список продуктов, содержащийся в БД
     */
    @GetMapping
    public List<ProductDTO> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::fromProduct)
                .collect(Collectors.toList());
    }

    /** Метод, сохраняющий объект в БД
     *
     * @param productDTO DTO объекта, сохраняемого в базу
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void add(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        // Сбрасываем ИД продукта в ноль, для того чтобы БД
        // именно сохранила как новый продукт, а не перезаписала
        // существующий при совпадении ИД
        product.setId(0L);
        productRepository.save(product);
    }

    /** Метод, сохраняющий объект в БД или
     * перезаписывающий его при совпадении ИД
     *
     * @param productDTO DTO объекта, сохраняемого в базу
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/update")
    public void addOrUpdate(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productRepository.save(product);
    }

    /** Метод, удаляющий объект из БД
     *
     * @param id - ID удаляемого объекта
     * @return - возвращаемый http-статус
     */
    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        productRepository.delete(productRepository.getById(id));
        return HttpStatus.OK.value();
    }
}
