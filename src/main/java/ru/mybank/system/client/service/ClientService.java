package ru.mybank.system.client.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mybank.system.client.entity.Client;
import ru.mybank.system.client.entity.Role;
import ru.mybank.system.client.entity.dto.ClientRequestDto;
import ru.mybank.system.client.entity.dto.ClientResponseDto;
import ru.mybank.system.client.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder encoder;

    public ClientResponseDto getClientById(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("пользователя с таким id нет"));
        return new ClientResponseDto(
                client.getFirstName(),
                client.getLastName(),
                client.getPhoneNumber());
    }

    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto){
        Client newClient = new Client(
                clientRequestDto.firstName(),
                clientRequestDto.lastName(),
                clientRequestDto.phoneNumber(),
                encoder.encode(clientRequestDto.password()));
        clientRepository.save(newClient);
        return new ClientResponseDto(
                newClient.getFirstName(),
                newClient.getLastName(),
                newClient.getPhoneNumber());
    }
}
