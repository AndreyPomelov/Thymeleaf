package com.example.thymeleaf.controller.dto;

import lombok.Data;

/** Класс, описывающий продукт, передаваемый по REST-протоколу
 * Маппится из класса Product, сущности которого содержатся в БД
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 * @see com.example.thymeleaf.model.entity.Product
 * @see com.example.thymeleaf.controller.mapper.ProductMapper
 */
@Data
public class ProductDTO {

    /** ID продукта */
    private Long id;

    /** Наименование продукта */
    private String title;

    /**  Стоимость продукта */
    private int price;
}