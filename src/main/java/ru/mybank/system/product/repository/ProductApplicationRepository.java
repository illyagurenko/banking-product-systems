package ru.mybank.system.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mybank.system.product.entity.ProductApplication;

@Repository
public interface ProductApplicationRepository extends JpaRepository<ProductApplication, Long> {
}
