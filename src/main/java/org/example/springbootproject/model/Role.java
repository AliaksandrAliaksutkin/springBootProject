package org.example.springbootproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_role")
    private Long id_role;
    @Column(name = "role")
    private String role;
    @OneToOne(mappedBy = "role", orphanRemoval = true)
    private User user;

    public Role(Long id_role, String role) {
        this.id_role = id_role;
        this.role = role;
    }

    public Role(Role role) {
    }
}