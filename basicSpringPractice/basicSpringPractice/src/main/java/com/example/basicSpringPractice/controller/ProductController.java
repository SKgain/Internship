package com.example.basicSpringPractice.controller;

import com.example.basicSpringPractice.DTO.requestDTO.ProductRequestDTO;
import com.example.basicSpringPractice.DTO.responseDTO.ProductResponseDT0;
import com.example.basicSpringPractice.entity.PaginatedResponse;
import com.example.basicSpringPractice.entity.PaginationArgs;
import com.example.basicSpringPractice.entity.Product;
import com.example.basicSpringPractice.service.ProductService;
import com.example.basicSpringPractice.util.PaginationUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.basicSpringPractice.constant.AppConstant.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final PaginationUtil  paginationUtil;
    private final ModelMapper modelMapper;

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(
            @Valid @RequestBody ProductRequestDTO product
    ) {
        return productService.addProduct(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductResponseDT0>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<ProductResponseDT0> updateProduct(
            @Valid @RequestBody ProductRequestDTO dto,
            @PathVariable int id
    ) {
        return productService.updateProduct(dto, id);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable int id
    ){
        return productService.deleteProduct(id);
    }
//specification api
    @GetMapping("/product/search")
    public ResponseEntity<List<ProductResponseDT0>> getAllProductsBySearch(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double price
    )
    {
        return productService.getAllProductsBySearch(id, name, type, price);
    }
//pagination and sorting
    @GetMapping("/product/pagination")
    public ResponseEntity<PaginatedResponse<ProductResponseDT0>> getAllProductsByPagination(
            @RequestParam(name=PAGE_NO,defaultValue = "0") int pageNo,
            @RequestParam(name=PAGE_SIZE, defaultValue = "10") int size,
            @RequestParam(name = ORDER_BY, defaultValue = "id") String orderBy,
            @RequestParam(name = SORT_ORDER, defaultValue = "asc") String sortOrder
    ){
        PaginationArgs paginationArgs = new PaginationArgs(pageNo, size, orderBy, sortOrder);
        Page<Product> page = productService.getAllProductsByPagination(paginationArgs);
        Page<ProductResponseDT0> dtoPage = page.map(product ->
                new ProductResponseDT0(
                        product.getName(),
                        product.getDescription(),
                        product.getUnitPrice(),
                        product.getQuantity(),
                        product.getType()
                )
        );
//        return new ResponseEntity<>(paginationUtil.buildPaginatedResponse(dtoPage), HttpStatus.OK);
        return ResponseEntity.ok().body(paginationUtil.buildPaginatedResponse(dtoPage));
    }
}
