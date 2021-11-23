package org.example.springbootproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //?? SEQUENCE
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
