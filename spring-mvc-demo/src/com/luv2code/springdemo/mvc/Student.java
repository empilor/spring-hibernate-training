package com.luv2code.springdemo.mvc;

import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    
    private String country;
    
    private String favoriteLanguage;
    
    private String[] operatingSystems;

    public Student() {
    }

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
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }
    
    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Student [firstName=").append(firstName).append(", lastName=").append(lastName)
		.append(", country=").append(country).append(", favoriteLanguage=").append(favoriteLanguage)
		.append(", operatingSystems=").append(Arrays.toString(operatingSystems)).append("]");
	return builder.toString();
    }
}
