package ru.neoflex.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private int age;

}
