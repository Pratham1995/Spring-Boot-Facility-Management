package com.example.Model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="Facility",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long FacilityID;

    private String name;
    private String FacilityType;

    public Facility(String facilityName, String facilityType) {

        this.name = facilityName;
        FacilityType = facilityType;
    }

    public Facility() {
    }

    public Long getFacilityID() {
        return FacilityID;
    }

    public void setFacilityID(Long facilityID) {
        FacilityID = facilityID;
    }

    public String getFacilityName() {
        return name;
    }

    public void setFacilityName(String facilityName) {
        this.name = facilityName;
    }

    public String getFacilityType() {
        return FacilityType;
    }

    public void setFacilityType(String facilityType) {
        FacilityType = facilityType;
    }
}
