package com.example.Repository;

import com.example.Model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility,Long> {
    Facility findByName(String name);
}
