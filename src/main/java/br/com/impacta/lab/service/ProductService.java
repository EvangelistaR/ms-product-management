package br.com.impacta.lab.service;

import br.com.impacta.lab.dto.ProductPatchRequest;
import br.com.impacta.lab.dto.ProductUpdateRequest;
import br.com.impacta.lab.entity.ProductEntity;
import br.com.impacta.lab.dto.ProductRequest;
import br.com.impacta.lab.dto.ProductResponse;
import br.com.impacta.lab.exception.NotFoundException;
import br.com.impacta.lab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> listAll() {
        List<ProductEntity> products = productRepository.listAll();

        return products.stream()
                .map(p -> toResponse(p))
                .toList();
    }

    public ProductResponse findById(Long id) {
        ProductEntity product = productRepository.getById(id);


        if  (product == null) {
            throw new NotFoundException(id);
        } else {
            return toResponse(product);
        }
    }

    public ProductResponse createProduct(ProductRequest request) {
        ProductEntity productEntity = toEntity(request);
        productEntity = productRepository.createProduct(productEntity);

        return toResponse(productEntity);
    }

    public ProductEntity toEntity(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setDescription(productRequest.description());
        productEntity.setPrice(productRequest.price());
        productEntity.setName(productRequest.name());

        return productEntity;
    }

    public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
        ProductEntity product = productRepository.getById(id);

        if (product == null) {
            throw new NotFoundException(id);
        }

        product.setName(request.name());
        product.setPrice(request.price());
        product.setDescription(request.description());

        return toResponse(productRepository.updateProduct(product));
    }

    public ProductResponse patchProduct(Long id, ProductPatchRequest request) {
        ProductEntity product = productRepository.getById(id);
        if (product == null) {
            throw new NotFoundException(id);
        }

        request.name().ifPresent(product::setName);
        request.price().ifPresent( price -> product.setPrice(price));
        request.description().ifPresent(product::setDescription);

        return toResponse(productRepository.updateProduct(product));

    }

    public void deleteProduct(Long id) {
        ProductEntity product = productRepository.getById(id);

        if (product == null) {
            throw new NotFoundException(id);
        }

        productRepository.delete(product);
    }


    public ProductResponse toResponse (ProductEntity productEntity) {
        return new ProductResponse(productEntity.getId(), productEntity.getName(), productEntity.getPrice(), productEntity.getDescription());
    }
}
