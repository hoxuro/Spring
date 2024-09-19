package com.banana.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Student.selectall", query = "SELECT s FROM student s")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private int curso;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "escuela")
    private School school;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
          name = "estudiantes_proyectos",
          joinColumns = {@JoinColumn(name = "estudiante")},
          inverseJoinColumns = {@JoinColumn(name = "proyecto")}
    )
    @ToString.Exclude
    private List<Project> projects;

    public boolean isValid() {
        return this.nombre != null && this.apellido != null && this.curso > 0;
    }
}
