package com.projetodeestudo.course.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_payment")
@Setter @Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Payment implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Instant moment;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment(Instant moment, Order order) {
        this.moment = moment;
        this.order = order;
    }
}
