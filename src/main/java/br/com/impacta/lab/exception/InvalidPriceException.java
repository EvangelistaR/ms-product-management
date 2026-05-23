package br.com.impacta.lab.exception;

public class InvalidPriceException extends RuntimeException {

    public InvalidPriceException(String name, Double price) {
        super(name + " cannot be created with : " + price);
    }

}