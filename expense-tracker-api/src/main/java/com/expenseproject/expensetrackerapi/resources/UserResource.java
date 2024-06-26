package com.expenseproject.expensetrackerapi.resources;

import com.expenseproject.expensetrackerapi.Constants;
import com.expenseproject.expensetrackerapi.domain.User;
import com.expenseproject.expensetrackerapi.services.UserService;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String,Object> userMap){
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email,password);
//        Map<String,String> map = new HashMap<>();
//        map.put("message","user logged in successfully");
        return new ResponseEntity<>(generateJJWTToken(user),HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String)  userMap.get("email");
        String password = (String) userMap.get("password");
    User user = userService.registerUser(firstName,lastName,email,password);
//   Map<String,String> map = new HashMap<>();
//   map.put("message","registered successfully");
   return new ResponseEntity<>(generateJJWTToken(user), HttpStatus.OK);
    }

    private Map<String,String> generateJJWTToken(User user)
    {
        long timestamp =  System.currentTimeMillis();

        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.Token_Validity))
                .claim("userId",user.getUserId())
                .claim("email",user.getEmail())
                .claim("firstName",user.getFirstName())
                .claim("lastName",user.getLastName())
                .compact();
       Map<String,String> map = new HashMap<>();
       map.put("token",token);
      return map;

    }
}