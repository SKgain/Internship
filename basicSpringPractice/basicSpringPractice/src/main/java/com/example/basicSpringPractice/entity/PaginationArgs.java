package com.example.basicSpringPractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationArgs {
    private int page;
    private int pageSize;
    private String sortBy;
    private String orderBy;
}
