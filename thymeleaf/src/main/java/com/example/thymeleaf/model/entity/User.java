package com.example.thymeleaf.model.entity;

import lombok.Data;
import javax.persistence.*;

/** Класс, описывающий пользователя
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;
}
