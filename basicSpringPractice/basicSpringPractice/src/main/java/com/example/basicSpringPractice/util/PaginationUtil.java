package com.example.basicSpringPractice.util;

import com.example.basicSpringPractice.entity.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {

    public <T>PaginatedResponse<T> buildPaginatedResponse(Page<T> page) {
        PaginatedResponse<T> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setDataList(page.getContent());
        paginatedResponse.setPageNo(page.getNumber());
        paginatedResponse.setTotalPage(page.getTotalPages());
        paginatedResponse.setTotalRecord(page.getTotalElements());
        paginatedResponse.setPageSize(page.getSize());
        paginatedResponse.setHasNext(page.hasNext());
        paginatedResponse.setHasPrevious(page.hasPrevious());
        return paginatedResponse;
    }
}
