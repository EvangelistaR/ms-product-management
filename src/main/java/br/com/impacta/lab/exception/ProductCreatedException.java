package br.com.impacta.lab.exception;

public class ProductCreatedException extends RuntimeException {
    public ProductCreatedException(String name) {
        super(name + "already exists");
    }
}
