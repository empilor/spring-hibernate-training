package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    
    @RequestMapping("/showForm")
    public String showForm() {
	return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
	return "helloworld";
    }
    
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
	
	String studentName = request.getParameter("studentName");
	
	studentName = studentName.toUpperCase();
	
	String messageString = "Yo! " + studentName;
	
	model.addAttribute("message", messageString);
	
	return "helloworld";
    }
    
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
	
	theName = theName.toUpperCase();
	
	String messageString = "Hey my friend from v3! " + theName;
	
	model.addAttribute("message", messageString);
	
	return "helloworld";
    }
}
