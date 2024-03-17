package com.expenseproject.expensetrackerapi.repository;

import com.expenseproject.expensetrackerapi.domain.User;
import com.expenseproject.expensetrackerapi.exception.EtAuthException;
import org.springframework.stereotype.Repository;



public interface UserRepository {



    Integer create(String firstName,String lastName,String email,String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);
    User findById(Integer userId);
}
