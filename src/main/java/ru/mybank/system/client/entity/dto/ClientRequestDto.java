package ru.mybank.system.client.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientRequestDto(
    @NotBlank(message = "имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "имя должно быть от 2 до 30 символов")
    String firstName,
    @NotBlank(message = "фамилия не должна быть пустой")
    @Size(min = 2, max = 30, message = "фамилия должна быть от 2 до 30 символов")
    String lastName,
    @NotBlank(message = "номер не должен быть пустым")
    @Pattern(regexp = "^(\\+7|8)?\\d{10}$", message = "неверный формат номера телефона")
    String phoneNumber,
    @NotBlank(message = "пароль не должен быть пустым")
    @Size(min = 2, max = 30, message = "пароль должен быть от 2 до 30 символов")
    String password
) {
}
