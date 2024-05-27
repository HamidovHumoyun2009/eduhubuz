package com.example.educational_center;

import com.example.components.ApiResponse;
import com.example.eduSpeciality.EduSpecialityEntity;
import com.example.eduSpeciality.EduSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EduService {
    @Autowired
    private EduRepository eduRepository;

    @Autowired
    private EduSpecialityRepository eduSpecialityRepository;

    public ApiResponse create(EduDTO dto) {

        EducationalCenterEntity educationalCenterEntity = new EducationalCenterEntity();
        educationalCenterEntity.setName(dto.getName());
        educationalCenterEntity.setAddress(dto.getAddress());
        educationalCenterEntity.setContactInfo(dto.getContactInfo());
        educationalCenterEntity.setInfo(dto.getInfo());

        eduRepository.save(educationalCenterEntity);

        return new ApiResponse(true, "Muvaffaqiyatli yaratildi!", educationalCenterEntity);
    }

    public ApiResponse updateById(int id, EduDTO dto) {

        EducationalCenterEntity educationalCenterEntity = eduRepository.getById(id);

        educationalCenterEntity.setName(dto.getName());
        educationalCenterEntity.setAddress(dto.getAddress());
        educationalCenterEntity.setContactInfo(dto.getContactInfo());
        educationalCenterEntity.setInfo(dto.getInfo());

        eduRepository.save(educationalCenterEntity);

        return new ApiResponse(true,
                "Muvaffaqiyatli yangilandi!",educationalCenterEntity);
    }

    public ApiResponse deleteById(int id) {
        eduRepository.deleteById(id);
        return new ApiResponse(true, "SUCCES!");
    }

    public List<EduDTO>getAll() {

        List<EducationalCenterEntity> all = eduRepository.findAll();

        List<EduDTO> dtos = new ArrayList<>();

        for (EducationalCenterEntity entity : all) {

            EduDTO dto = toDto(entity);

            dtos.add(dto);
        }

        return dtos;
    }

    private EduDTO toDto(EducationalCenterEntity entity) {
        EduDTO dto = new EduDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setContactInfo(entity.getContactInfo());
        dto.setInfo(entity.getInfo());
        return dto;
    }

    public EduDTO getById(int id) {
        EducationalCenterEntity entity = eduRepository.getById(id);

        EduDTO dto = toDto(entity);

        return dto;
    }

    public List<EduDTO> getByName(String name) {
        return eduRepository.findAllByName(name);
    }

    public List<EduDTO> getByAddress(String address) {
        return eduRepository.findAllByAddress(address);
    }
}

 