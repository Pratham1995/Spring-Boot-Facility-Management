package com.example.Service;

import com.example.Model.Facility;
import com.example.Repository.FacilityRepository;
import com.example.web.DTO.FacilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class FacilityServiceImpl  implements  FacilityService{
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Facility findByFacilityName(String name) {
        return facilityRepository.findByName(name);
    }

    @Override
    public Facility add(FacilityDTO facilityDTO) {
        Facility add= new Facility(facilityDTO.getFacilityName(),facilityDTO.getFacilityType());
        return facilityRepository.save(add);
    }
}
