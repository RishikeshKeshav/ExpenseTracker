package com.expenseproject.expensetrackerapi.services;

import com.expenseproject.expensetrackerapi.domain.User;
import com.expenseproject.expensetrackerapi.exception.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName,String lastName,String email,String password) throws EtAuthException;
}
