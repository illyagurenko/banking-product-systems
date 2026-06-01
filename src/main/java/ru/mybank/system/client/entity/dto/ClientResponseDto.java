package ru.mybank.system.client.entity.dto;

public record ClientResponseDto(
    String firstName,
    String lastName,
    String phoneNumber
) {
}
