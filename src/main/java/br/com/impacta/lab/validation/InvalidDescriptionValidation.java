package br.com.impacta.lab.validation;

import br.com.impacta.lab.dto.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class InvalidDescriptionValidation implements BusinessValidation{

    @Override
    public void validate(ProductRequest request){

        if ("string".equals(request.description())){
            throw new RuntimeException("Invalid description");
        }
    }

}
