package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
    
    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;
    
    @NotNull(message="is required")
    @Min(value = 0,message = "must be greater than or equal to zero")
    @Max(value = 10,message = "must be less than or equal to ten")
    private Integer freePasses;
    
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters / digits")
    private String postalCode;
    
    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String courseCode;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Customer [firstName=").append(firstName).append(", lastName=").append(lastName)
		.append(", freePasses=").append(freePasses).append(", postalCode=").append(postalCode).append("]");
	return builder.toString();
    }    
}
