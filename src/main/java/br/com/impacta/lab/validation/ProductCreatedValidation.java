package br.com.impacta.lab.validation;

import br.com.impacta.lab.dto.ProductRequest;
import br.com.impacta.lab.entity.ProductEntity;
import br.com.impacta.lab.exception.ProductCreatedException;
import br.com.impacta.lab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCreatedValidation  implements BusinessValidation{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void validate(ProductRequest request) {
        List<ProductEntity> listProducts = productRepository.listAll();

        for (var product : listProducts) {
            if (request.name().equals(product.getName())) {
                throw new ProductCreatedException(request.name());
            }
        }
    }
}
