package com.example.web.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public  class FacilityDTO {

        @NotNull(message="Facility name should not be empty ")
        @NotEmpty(message = "Facility name should not be empty")
        @Size(min=5, max=30)
        private String name;

        private String FacilityType;

        public FacilityDTO() {
        }

        public String getFacilityName() {
            return name;
        }

        public void setFacilityName(String facilityName) {
            name = facilityName;
        }

        public String getFacilityType() {
            return FacilityType;
        }

        public void setFacilityType(String facilityType) {
            FacilityType = facilityType;
        }
    }
