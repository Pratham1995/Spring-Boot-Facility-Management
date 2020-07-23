package com.example.Service;

import com.example.Model.Facility;
import com.example.web.DTO.FacilityDTO;

import javax.validation.Valid;

public interface FacilityService {
    Facility add(FacilityDTO facilityDTO);
    Facility findByFacilityName(String name);
}
