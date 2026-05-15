package br.com.impacta.lab.repository;

import br.com.impacta.lab.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<ProductEntity> products = new ArrayList<>();

    private Long sequential = 1l;

    public List<ProductEntity> listAll() {
        return products;
    }

    public ProductEntity getById(Long id) {
        for ( var product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        productEntity.setId(sequential);
        products.add(productEntity);

        sequential++;

        return productEntity;
    }
}
