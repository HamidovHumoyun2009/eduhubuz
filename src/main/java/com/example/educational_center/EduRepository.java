package com.example.educational_center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EduRepository extends JpaRepository<EducationalCenterEntity, Integer> {

    List<EducationalCenterEntity>findAllByName(String name);

    List<EducationalCenterEntity> findAllByAddress(String address);
}
