package com.skc.repository;

import com.skc.entity.Todo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> {
    //pagingandsortingrepository supports basic Crud Operations

}
