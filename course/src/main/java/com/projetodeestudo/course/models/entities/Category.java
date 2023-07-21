package com.projetodeestudo.course.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_category")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Setter(AccessLevel.NONE)
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
