package ru.mybank.system.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mybank.system.product.entity.Account;
import ru.mybank.system.product.entity.ProductApplication;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "phone_number", nullable = false, length = 12, unique = true)
    private String phoneNumber;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 15)
    private Role role;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ProductApplication> applications;

    @OneToMany(mappedBy = "mainClient", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public Client(String firstName, String lastName, String phoneNumber, String passwordHash) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.role = Role.ROLE_USER;
    }

}
