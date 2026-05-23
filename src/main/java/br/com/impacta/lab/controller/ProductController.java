package br.com.impacta.lab.controller;

import br.com.impacta.lab.dto.*;
import br.com.impacta.lab.service.ProductService;
import br.com.impacta.lab.validation.BusinessValidation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    private List<BusinessValidation> validations;

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

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product was successfully created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))}),
    })
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        for (var validation : validations) {
            validation.validate(productRequest);
        }

        ProductResponse productResponse = productService.createProduct(productRequest);

        return ResponseEntity.created(null).body(productResponse);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product was successfully updated",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "invalid request",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductUpdateRequest productRequest) {
        ProductResponse product = productService.updateProduct(id, productRequest);

        return ResponseEntity.ok(product);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product was successfully updated",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "invalid request",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) }) })
    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> patchProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductPatchRequest productRequest) {
        ProductResponse product = productService.patchProduct(id, productRequest);

        return ResponseEntity.ok(product);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "Product was successfully deleted",
                content = { @Content(mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", description = "Not Found",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class)) }) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.accepted().build();
    }
}
