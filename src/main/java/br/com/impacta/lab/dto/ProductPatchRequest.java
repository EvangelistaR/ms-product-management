package br.com.impacta.lab.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record ProductPatchRequest(
        Optional<@Size(min = 2, max = 100, message = "Name should have more than 1 character and less than 101") String> name,
        Optional<@Positive(message = "Price should be positive") Double> price,
        Optional<@Size(max = 200, message = "Description should have 200 characters at maximum") String> description){
}
