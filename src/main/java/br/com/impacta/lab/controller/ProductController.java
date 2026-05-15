package br.com.impacta.lab.controller;

import br.com.impacta.lab.dto.ProductRequest;
import br.com.impacta.lab.dto.ProductResponse;
import br.com.impacta.lab.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listAll() {
        List<ProductResponse> products = productService.listAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("id") Long id) {
       ProductResponse productResponse = productService.findById(id);

        if (productResponse == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productResponse);
        }
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);

        return ResponseEntity.created(null).body(productResponse);
    }
}
