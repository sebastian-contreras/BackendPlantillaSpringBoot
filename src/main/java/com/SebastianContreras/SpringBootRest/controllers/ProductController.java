package com.SebastianContreras.SpringBootRest.controllers;

import com.SebastianContreras.SpringBootRest.controllers.dto.MakerDto;
import com.SebastianContreras.SpringBootRest.controllers.dto.ProductDto;
import com.SebastianContreras.SpringBootRest.entities.Product;
import com.SebastianContreras.SpringBootRest.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDto productDto = ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .maker(product.getMaker())
                    .build();
            return ResponseEntity.ok(productDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findAll() {
        List<ProductDto> productDtoList = productService.findAll().stream()
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker())
                        .build())
                .toList();
        return ResponseEntity.ok(productDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException {
        if (productDto.getName().isBlank() || productDto.getPrice() == null || productDto.getMaker() == null) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .maker(productDto.getMaker()).build());
        return ResponseEntity.created(new URI("/api/product/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setMaker(productDto.getMaker());
            productService.save(product);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(id!=null){
            productService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().body("El parametro id se encuentra vacio");
    }
}
