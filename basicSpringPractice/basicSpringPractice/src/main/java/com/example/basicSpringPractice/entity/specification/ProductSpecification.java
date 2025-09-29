package com.example.basicSpringPractice.entity.specification;

import com.example.basicSpringPractice.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasId(Integer id) {
        return (root, query, cb) ->
                id == null ? null : cb.equal(root.get("id"), id);
    }

    public static Specification<Product> hasName(String name) {
        return (root, query, cb) ->
                name == null ? null : cb.equal(root.get("name"), name);
    }

    public static Specification<Product> hasUnitPrice(Double unitPrice) {
        return (root, query, cb) ->
                unitPrice == null ? null : cb.greaterThanOrEqualTo(root.get("unitPrice"), unitPrice);
    }

    public static Specification<Product> hasType(String type) {
        return (root, query, cb) ->
                type == null ? null : cb.equal(root.get("type"), type);
    }
}
