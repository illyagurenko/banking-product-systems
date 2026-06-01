package ru.mybank.system.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mybank.system.product.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
