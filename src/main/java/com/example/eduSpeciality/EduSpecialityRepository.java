package com.example.eduSpeciality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EduSpecialityRepository extends JpaRepository<EduSpecialityEntity, Integer> {
    List<EduSpecialityEntity> findAllByEducationalCenterId(Integer eduCenterId);

    List<EduSpecialityEntity> findAllByName(String name);

    List<EduSpecialityEntity> findAllByInfo(String info);

}
