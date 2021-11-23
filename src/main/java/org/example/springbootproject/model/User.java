package org.example.springbootproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

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

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address_user")
    private Address address;

    public User(Long id, String firstName, String lastName, Integer age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String firstName, String lastName, Integer age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public User(Long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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
