package ru.neoflex.demo.service;

import org.springframework.stereotype.Service;
import ru.neoflex.demo.controller.dto.PersonRequestDto;
import ru.neoflex.demo.controller.dto.PersonResponseDto;

import java.time.LocalDate;
import java.util.List;

@Service
public class DemoService {

    public List<PersonResponseDto> getPersons() {

        return List.of(
                PersonResponseDto.builder().lastName("Ezhak").firstName("Sasha").age(20).email("bdsfkl@glfk.com").build(),
                PersonResponseDto.builder().lastName("Vlasov").firstName("Dmitriy").age(19).email("bsfsdf@glfk.com").build(),
                PersonResponseDto.builder().lastName("Ivanov").firstName("Ivan").age(40).email("ivann@glfk.com").build(),
                PersonResponseDto.builder().lastName("Galkin").firstName("Andrey").age(82).email("babbab@glfk.com").build(),
                PersonResponseDto.builder().lastName("Kuznetsov").firstName("Anatoliy").age(64).email("dfsdsf@glfk.com").build()
        );
    }

    public PersonResponseDto updateLastName(PersonRequestDto request) {

        return PersonResponseDto
                .builder()
                .lastName("update " + request.getLastName())
                .firstName(request.getFirstName())
                .age(request.getAge())
                .email(request.getEmail())
                .build();
    }

    public LocalDate getBirthDate(PersonRequestDto request) {

        return LocalDate.now().minusYears(request.getAge());
    }
}
