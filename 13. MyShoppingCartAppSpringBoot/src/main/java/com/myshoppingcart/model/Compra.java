package com.myshoppingcart.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto")
    private Producto producto;

    private int cantidad;
    private LocalDate fecha;
}