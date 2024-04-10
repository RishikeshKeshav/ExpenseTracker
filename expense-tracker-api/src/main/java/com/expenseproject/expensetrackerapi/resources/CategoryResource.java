package com.expenseproject.expensetrackerapi.resources;


import com.expenseproject.expensetrackerapi.domain.Category;
import com.expenseproject.expensetrackerapi.services.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {



    @Autowired
    CategoryService categoryService;
    @GetMapping("")
    public String getAllCategories(HttpServletRequest request){
        int userId = (Integer)request.getAttribute("userId");
        return "AUthenticated User" + userId;
    }

    @PostMapping("")
    public ResponseEntity<Category> addCategory(HttpServletRequest request, @RequestBody Map<String,Object> categoryMap){

        int userId = (Integer) request.getAttribute("userId");
        String  title = (String)request.getAttribute("title");
        String description = (String)request.getAttribute("description");
        Category category = categoryService.createCategory(userId,title,description);

        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }


}
