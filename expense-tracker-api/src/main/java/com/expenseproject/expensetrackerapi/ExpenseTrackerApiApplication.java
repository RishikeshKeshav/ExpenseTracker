package com.expenseproject.expensetrackerapi;

import com.expenseproject.expensetrackerapi.filters.AuthFilters;
import jakarta.servlet.FilterRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApiApplication.class, args);
	}
      @Bean
	public FilterRegistrationBean<AuthFilters> filtersFilterRegistrationBean(){
		FilterRegistrationBean<AuthFilters> registrationBean =new FilterRegistrationBean<>();
		AuthFilters authFilters = new AuthFilters();
		registrationBean.setFilter(authFilters);
		registrationBean.addUrlPatterns("/api/categories/*");
		return registrationBean;
	  }
}
