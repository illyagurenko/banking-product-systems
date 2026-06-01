package ru.mybank.system.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mybank.system.client.entity.Client;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "product_applications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "product_type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "status", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

}
