package com.example.eduSpeciality;

import com.example.components.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EduSpecialityService {

    @Autowired
    private EduSpecialityRepository eduSpecialityRepository;

    public ApiResponse create(EduSpecialtyDto dto) {
        EduSpecialityEntity eduSpeciality = new EduSpecialityEntity();
        eduSpeciality.setName(dto.getName());
        eduSpeciality.setInfo(dto.getInfo());
        eduSpeciality.setEduCenterId(dto.getEdu_center_id());

        eduSpecialityRepository.save(eduSpeciality);

        return new ApiResponse(true, "Muvaffaqiyatli yaratildi!", eduSpeciality);
    }

    public List<EduSpecialityEntity>getAll() {
        List<EduSpecialityEntity> all = eduSpecialityRepository.findAll();
        return all;
    }

    public EduSpecialityEntity getById(int id) {
        return eduSpecialityRepository.getById(id);
    }

    public List<EduSpecialityEntity> getByName(String name) {
        return eduSpecialityRepository.findAllByName(name);
    }

    public List<EduSpecialityEntity> getAllByEduCenterId(int eduCenterId) {
        return eduSpecialityRepository.findAllByEducationalCenterId(eduCenterId);
    }

    public ApiResponse deleteById(int id) {
        eduSpecialityRepository.deleteById(id);
        return new ApiResponse(true, "O'chdi");
    }

    public ApiResponse updateById(int id, EduSpecialtyDto dto) {

        EduSpecialityEntity eduSpeciality =eduSpecialityRepository.getById(id);

        eduSpeciality.setName(dto.getName());
        eduSpeciality.setInfo(dto.getInfo());
        eduSpeciality.setEduSpecialityId(dto.getEdu_center_id());

        eduSpecialityRepository.save(eduSpeciality);

        return new ApiResponse(true,
                "Muvaffaqiyatli yangilandi!",eduSpeciality);
    }
}
