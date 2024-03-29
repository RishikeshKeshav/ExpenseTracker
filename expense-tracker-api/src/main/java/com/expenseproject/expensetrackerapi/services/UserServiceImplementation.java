package com.expenseproject.expensetrackerapi.services;

import com.expenseproject.expensetrackerapi.domain.User;
import com.expenseproject.expensetrackerapi.exception.EtAuthException;
import com.expenseproject.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;
@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User validateUser(String email, String password) throws EtAuthException {

        if(email!=null){
            email = email.toLowerCase();
        }
        if(password!=null){
            password = password.toLowerCase();
        }
    return userRepository.findByEmailAndPassword(email,password);

    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern =Pattern.compile("^(.+)@(.+)$");
        if(email!=null){
            email = email.toLowerCase();
        }
        if(!pattern.matcher(email).matches())
        {
            throw new EtAuthException("Invalid email format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if(count>0){
            throw new EtAuthException("email is already registered");
        }
        Integer userId = userRepository.create(firstName,lastName,email,password);
        System.out.print(userId);
        return userRepository.findById(userId);
    }
}
