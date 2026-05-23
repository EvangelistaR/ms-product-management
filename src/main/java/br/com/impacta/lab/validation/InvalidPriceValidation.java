package br.com.impacta.lab.validation;

import br.com.impacta.lab.dto.ProductRequest;
import br.com.impacta.lab.exception.InvalidPriceException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class InvalidPriceValidation implements BusinessValidation {
    @Override
    public void validate(ProductRequest request){
        if (request.price() > 10000) {
            throw new InvalidPriceException(request.name(), request.price());
        }
    }
}
