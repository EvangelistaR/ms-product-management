package br.com.impacta.lab.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.impacta.lab.dto.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerGlobal  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidFields(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();

        for (var fieldError : fieldErrors) {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(new ErrorResponse(400, "Invalid request", errors));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGenericError(NotFoundException exception) {
        return ResponseEntity.status(404).body(new ErrorResponse(404, exception.getMessage(), null));
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPrice(InvalidPriceException exception) {
        return ResponseEntity.status(404).body(new ErrorResponse(404, exception.getMessage(), null));
    }

    @ExceptionHandler(ProductCreatedException.class)
    public ResponseEntity<ErrorResponse> handleProductCreated(ProductCreatedException exception) {
        return ResponseEntity.status(420).body(new ErrorResponse(420, exception.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericError(Exception exception) {
        List<String> errors = new ArrayList<>();

        System.out.println("Exception message: " + exception.getMessage());

        return ResponseEntity.internalServerError().body(new ErrorResponse(500, "Internal error", errors));
    }
}
