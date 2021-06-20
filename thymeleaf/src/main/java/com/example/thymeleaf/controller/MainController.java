package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.entity.Product;
import com.example.thymeleaf.model.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** Класс-контролллер
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Controller
@RequestMapping("/")
public class MainController {

    /** Ссылка на репозиторий, осуществляющий взаимодействие с БД */
    private final ProductRepository productRepository;

    /** Конструктор */
    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /** Метод, принимающий гет-запрос по корневому пути
     *
     * @param model модель, в которую передаётся список продуктов
     * @return имя страницы, передаваемой клиенту
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index";
    }

    /** Метод, принимающий гет-запрос перехода на страницу
     *
     * с формой для добавления продукта в список
     * @param model модель, в которую передаётся пустой объект
     *              для заполнения его полей через форму
     * @return имя страницы с формой
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }

    /** Метод, принимающий пост-запрос с данными из заполненной формы
     *
     * @param product экземпляр класса Product с заполненными полями
     * @see Product
     * @return имя страницы с формой
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(Product product) {
        productRepository.save(product);
        return "add";
    }

    /** Метод, принимающий гет-запрос для удаления продукта из БД
     *
     * @param id ИД продукта в БД
     * @return редирект на главную страницу
     */
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
        return "redirect:/";
    }
}