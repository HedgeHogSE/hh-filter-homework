package ru.neoflex.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.demo.controller.dto.PersonRequestDto;
import ru.neoflex.demo.controller.dto.PersonResponseDto;
import ru.neoflex.demo.service.DemoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/persons")
    public List<PersonResponseDto> getPersons() {

        return demoService.getPersons();
    }

    @PostMapping("/update")
    public PersonResponseDto updateLastName(@RequestBody PersonRequestDto personRequestDto) {

        return demoService.updateLastName(personRequestDto);
    }

    @PostMapping("/birthDate")
    public LocalDate getBirthDate(@RequestBody PersonRequestDto personRequestDto) {

        return demoService.getBirthDate(personRequestDto);
    }
}
