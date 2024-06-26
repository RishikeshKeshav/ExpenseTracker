package com.expenseproject.expensetrackerapi.services;

import com.expenseproject.expensetrackerapi.domain.Category;
import com.expenseproject.expensetrackerapi.exception.EtBadRequestException;
import com.expenseproject.expensetrackerapi.exception.EtResourceNotFoundException;
import com.expenseproject.expensetrackerapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{


    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories(Integer userId) {
        return null;
    }

    @Override
    public Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Category createCategory(Integer userId, String title, String description) throws EtBadRequestException {
       int categoryId = categoryRepository.create(userId,title,description);
        return categoryRepository.findById(userId,categoryId);
    }

    @Override
    public void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException {

    }

    @Override
    public void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException {

    }
}
