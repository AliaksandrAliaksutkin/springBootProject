package org.example.springbootproject.model;
import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {
    @Id
    // Определяет простой первичный ключ, состоящий из одного поля;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)     //автоматическая генерация значения первичного ключа
    @Column(name = "id_user")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address_user")
    private Address address;

    public User(String firstName, String lastName, Integer age, String password, String role, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.role = role;
        this.address = address;
    }

    public User(String firstName, String lastName, Integer age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public User(Long id, String firstName, String lastName, Integer age, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
