package com.example.thymeleaf.model.entity;

import lombok.*;
import javax.persistence.*;

/** Класс, описывающий продукт, сохраняемый в БД
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Data
@Entity
@Table(name = "products")
public class Product {

    /** ID продукта. Primary key в БД */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Наименование продукта */
    @Column(name = "title")
    private String title;

    /**  Стоимость продукта */
    @Column(name = "price")
    private int price;
}