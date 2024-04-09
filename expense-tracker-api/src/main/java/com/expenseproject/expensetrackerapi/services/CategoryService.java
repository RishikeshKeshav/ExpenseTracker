package com.expenseproject.expensetrackerapi.services;

import com.expenseproject.expensetrackerapi.domain.Category;
import com.expenseproject.expensetrackerapi.exception.EtBadRequestException;
import com.expenseproject.expensetrackerapi.exception.EtResourceNotFoundException;
import java.util.List;

public interface CategoryService {


    List<Category> getAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category createCategory(Integer userId, String title, String description) throws EtBadRequestException;


    void updateCategory(Integer userId,Integer categoryId,Category category) throws EtBadRequestException;


    void removeCategoryWithAllTransactions(Integer userId,Integer categoryId) throws EtResourceNotFoundException;
}