package br.com.impacta.lab.dto;

import java.util.List;

public record ErrorResponse(int status, String message, List<String> errors) {

}
