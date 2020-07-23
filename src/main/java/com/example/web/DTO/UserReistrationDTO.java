package com.example.web.DTO;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class UserReistrationDTO {

    @NotNull
    @NotBlank(message = "First name  may not be blank  ")
    @NotEmpty(message = "First name should not be empty  ")
    @Size(min=2, max=30)
    private String firstname;

    @NotEmpty(message = "Last name should not be empty  ")
    @NotBlank(message = "Last name  may not be blank  ")
    @NotNull
    @Size(min=2, max=30)
    private String lastname;

    @Email
    @NotEmpty(message = "Email should not be empty  ")
    @NotBlank(message = "Email may not be blank  ")
    @Size(min=2, max=30)
    private String email;

    @Email
    @NotEmpty(message = "Email should not be empty  ")
    @NotBlank(message = "Email may not be blank  ")
    @Size(min=2, max=30)
    private String confirmEmail;

    @NotEmpty
    @NotEmpty(message = "Password should not be empty  ")
    @NotBlank(message = "Password may not be blank  ")
    @Size(min=5, max=30)
    private String password;

    @NotEmpty
    @NotEmpty(message = "confirmPassword should not be empty  ")
    @NotBlank(message = "confirmPassword may not be blank  ")
    @Size(min=5, max=30)
    private String confirmPassword;

    @AssertTrue
    private Boolean terms;


    public UserReistrationDTO() {
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
