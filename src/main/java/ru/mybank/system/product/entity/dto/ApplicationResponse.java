package ru.mybank.system.product.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.mybank.system.product.entity.ProductStatus;
import ru.mybank.system.product.entity.ProductType;

import java.time.ZonedDateTime;

public record ApplicationResponse(
    Long clientId,
    ProductType productType,
    ProductStatus status,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String rejectionReason,
    ZonedDateTime createdAt,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    ZonedDateTime updatedAt
) {
}
