package com.skc.repository;

import com.skc.entity.SpringBootTodoApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<SpringBootTodoApplication, Long> {
    //pagingandsortingrepository supports basic Crud Operations

}
