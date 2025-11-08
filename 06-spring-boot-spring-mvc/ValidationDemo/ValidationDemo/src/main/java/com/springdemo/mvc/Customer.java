package com.springdemo.mvc;

import com.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Size(min = 3, message = "is required")
    private String firstName;

    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "value must be greater then 0 or equal to zero")
    @Max(value=10, message = "value must be less than or equal to 10")
    private Integer freePasses;


    @Pattern(regexp ="^[a-zA-Z0-9]{6}", message = "only 6 char/digits")
    private String postalCode;

    @CourseCode(value = "TOPS",message = "must start with TOPS")
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
}
