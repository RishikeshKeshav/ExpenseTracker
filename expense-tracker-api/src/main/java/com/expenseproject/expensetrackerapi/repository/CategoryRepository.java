package com.expenseproject.expensetrackerapi.repository;

import com.expenseproject.expensetrackerapi.domain.Category;
import com.expenseproject.expensetrackerapi.exception.EtBadRequestException;
import com.expenseproject.expensetrackerapi.exception.EtResourceNotFoundException;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId,Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId,String title,String description) throws EtBadRequestException;

    void update(Integer userId,Integer categoryId,Category category) throws EtBadRequestException;

    void removeById(Integer userId,Integer categoryId);
}
