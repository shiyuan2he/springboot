package com.hsy.springboot.hibernate.utils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
public class QueryTool {
    public static PageRequest buildPageRequest(int currentPage, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "ctime");
        } else {
            sort = new Sort(Sort.Direction.DESC, sortType);
        }

        return new PageRequest(currentPage, pageSize, sort);
    }
}
