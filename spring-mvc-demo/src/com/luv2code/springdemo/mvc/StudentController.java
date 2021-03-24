package com.luv2code.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    
    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
    @Value("#{favoriteLanguages}")
    private Map<String, String> favoriteLanguageOptions;
    
    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
	
	Student theStudent = new Student();
	
	theModel.addAttribute("student", theStudent);

	// add the country options to the model 
	theModel.addAttribute("theCountryOptions", countryOptions);
	
	theModel.addAttribute("theFavoriteLanguageOptions", favoriteLanguageOptions);
	    
	return "student-form";
    }
    
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
	
	System.out.println("theStudent: " + theStudent);
	return "student-confirmation";
    }
}
