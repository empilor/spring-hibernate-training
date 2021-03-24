package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funny")
public class SillyController {
    
    @RequestMapping("/showForm")
    public String displayForm() {
	return "silly";
    }
}
