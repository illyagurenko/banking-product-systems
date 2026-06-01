package ru.mybank.system.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mybank.system.product.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
