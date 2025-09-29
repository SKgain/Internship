package com.example.basicSpringPractice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PaginatedResponse<T> {
    private List<T> dataList;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private long totalRecord;
    private boolean hasNext;
    private boolean hasPrevious;
}
