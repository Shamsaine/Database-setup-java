package com.cmam.cmam.repositories;

import com.cmam.cmam.models.Facility;
import com.cmam.cmam.models.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
        List<Patient> findByFacilityId(Patient.ProgramStatus programStatus);
}
