package com.example.Controller;


import com.example.Model.Facility;
import com.example.Service.FacilityService;
import com.example.web.DTO.FacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/Facility")
public class FacilityController {
    private FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }
    @Autowired
    @ModelAttribute("Facility")
    public FacilityDTO facilityDTO(){
        return new FacilityDTO();
    }

    @GetMapping
    public String showFacility(){
        return "Facility";
    }

    @PostMapping
    public String Addfacility(@Valid @ModelAttribute("Facility") FacilityDTO facilityDTO, BindingResult result){
        Facility existing= facilityService.findByFacilityName(facilityDTO.getFacilityName());
        if(existing!=null){
            result.rejectValue("FacilityName",null,"There is already a facility registered by this name");
        }
        if(result.hasErrors()){
            return "Facility";
        }
        facilityService.add(facilityDTO);
        return "redirect:/Facility?success";
    }
}
