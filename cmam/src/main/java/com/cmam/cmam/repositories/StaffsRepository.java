package com.cmam.cmam.repositories;

import com.cmam.cmam.models.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StaffsRepository extends JpaRepository<Staffs, Long> {
    Optional<Staffs> findByEmail(String email);
}
