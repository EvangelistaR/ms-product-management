package br.com.impacta.lab.validation;

import br.com.impacta.lab.dto.ProductRequest;

public interface BusinessValidation {
    public void validate(ProductRequest request);
}
