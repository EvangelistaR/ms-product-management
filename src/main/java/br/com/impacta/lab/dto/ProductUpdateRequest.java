package br.com.impacta.lab.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductUpdateRequest(
        @NotBlank(message = "Name is required") @Size(min=2, max=100, message = "Name should have more than 1 character and less than 101") String name,
        @NotNull(message = "price is required")  @Positive(message= "price should be positive") Double price,
        @Size(max = 200, message = "description less or equal to 200 characters") String description) {

}
