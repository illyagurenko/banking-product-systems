package ru.mybank.system.product.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.mybank.system.product.entity.ProductType;

public record ApplicationCreateRequest(
        @NotNull(message = "Идентификатор клиента обязателен")
        Long clientId,
        @NotNull(message = "Тип продукта обязателен")
        ProductType type
) {
}
