package com.example.Controller;


import com.example.Model.UserJPA;
import com.example.Service.UserService;
import com.example.web.DTO.UserReistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService; //Constructor based injection

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserReistrationDTO userReistrationDTO(){
        return new UserReistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    //@ModelAttribute("user") contains form data
    @PostMapping
    public String RegisterUserAccount(@Valid @ModelAttribute("user")UserReistrationDTO userReistrationDTO, BindingResult bindingResult){
        UserJPA existing= userService.findByEmail(userReistrationDTO.getEmail());
        if(existing!=null){
            bindingResult.rejectValue("email",null,"There is already an account registered by this emaild id");
        }
        if(userReistrationDTO.getEmail()!=userReistrationDTO.getConfirmEmail()){
            //bindingResult.rejectValue("email","Confirm Email must be same as Email");
            bindingResult.rejectValue("confirmEmail","null","Confirm Email must be same as Email");
        }
        if(userReistrationDTO.getPassword()!=userReistrationDTO.getConfirmPassword()){
            //bindingResult.rejectValue("password","Confirm Password must be same as Password");
            bindingResult.rejectValue("confirmPassword","null","Confirm Password must be same as Password");
        }
        if(bindingResult.hasErrors()){
            return "registration";
        }


        userService.save(userReistrationDTO);
        return "redirect:/registration?success";

    }
}
