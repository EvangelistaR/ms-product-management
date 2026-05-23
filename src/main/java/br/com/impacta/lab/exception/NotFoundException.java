package br.com.impacta.lab.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id ) {
        // Product with id \{id} not found."
        super("Product " + id + " not found");
    }
}
