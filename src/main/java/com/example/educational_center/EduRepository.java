package com.example.educational_center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EduRepository extends JpaRepository<EducationalCenterEntity, Integer> {

    EducationalCenterEntity getByName(String name);

    EducationalCenterEntity getByAddress(String address);

    List<EduDTO> findAllByName(String name);

    List<EduDTO> findAllByAddress(String address);
}
