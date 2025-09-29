package com.example.basicSpringPractice.service;

import com.example.basicSpringPractice.DTO.requestDTO.ProductRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.ProductResponseDT0;
import com.example.basicSpringPractice.entity.PaginationArgs;
import com.example.basicSpringPractice.entity.Product;
import com.example.basicSpringPractice.entity.specification.ProductSpecification;
import com.example.basicSpringPractice.exception.ResourceNotFoundException;
import com.example.basicSpringPractice.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ResponseEntity<Product> addProduct(ProductRequestDTO productDTO) {
        return ResponseEntity.ok().body(productRepository.save(modelMapper.map(productDTO, Product.class)));
    }

    public ResponseEntity<List<ProductResponseDT0>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDT0> productResponseDTOList = new ArrayList<>();
        for (Product product : products) {
            productResponseDTOList.add(modelMapper.map(product, ProductResponseDT0.class));
        }
        return ResponseEntity.ok().body(productResponseDTOList);

    }

    public ResponseEntity<ProductResponseDT0> updateProduct(ProductRequestDTO dto, int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setUnitPrice(dto.getUnitPrice());
        product.setQuantity(dto.getQuantity());
        productRepository.save(product);

        Product p = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return ResponseEntity.ok().body(modelMapper.map(p, ProductResponseDT0.class));
    }

    public ResponseEntity<String> deleteProduct(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
        return ResponseEntity.ok().body("Product deleted");
    }

    public ResponseEntity<List<ProductResponseDT0>> getAllProductsBySearch(
            Integer id,
            String name,
            String type,
            Double price) {
        Specification<Product> spec = Specification.unrestricted();
        spec = spec.and(ProductSpecification.hasId(id))
                .and(ProductSpecification.hasName(name))
                .and(ProductSpecification.hasType(type))
                .and(ProductSpecification.hasUnitPrice(price));

        List<Product> products = productRepository.findAll(spec);
        List<ProductResponseDT0> productResponseDTOList = new ArrayList<>();
        for (Product product : products) {
            productResponseDTOList.add(modelMapper.map(product, ProductResponseDT0.class));
        }
        return ResponseEntity.ok().body(productResponseDTOList);
    }

    public Page<Product> getAllProductsByPagination(PaginationArgs paginationArgs) {
        Sort sortByOrder = paginationArgs.getOrderBy().equalsIgnoreCase("asc")
                ? Sort.by(paginationArgs.getOrderBy()).ascending()
                : Sort.by(paginationArgs.getOrderBy()).descending();

        Pageable pageable = PageRequest.of(paginationArgs.getPage(), paginationArgs.getPageSize(), sortByOrder);
        return productRepository.findAll(pageable);
    }
}
