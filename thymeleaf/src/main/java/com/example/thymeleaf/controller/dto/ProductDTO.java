package com.example.thymeleaf.controller.dto;

/** Класс, описывающий продукт, передаваемый по REST-протоколу
 * Маппится из класса Product, сущности которого содержатся в БД
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 * @see com.example.thymeleaf.model.entity.Product
 * @see com.example.thymeleaf.controller.mapper.ProductMapper
 */
public class ProductDTO {

    /** ID продукта */
    private Long id;

    /** Наименование продукта */
    private String title;

    /**  Стоимость продукта */
    private int price;

    /** Далее - стандартные геттеры и сеттеры */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}