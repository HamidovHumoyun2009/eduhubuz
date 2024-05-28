package com.example.educational_center;

import com.example.components.ApiResponse;
import com.example.eduSpeciality.EduSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
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

        EducationalCenterEntity educationalCenterEntity = eduRepository
                .findById(id)
                        .orElseThrow(() -> new RuntimeException("Markaz topilmadi"));

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

    public EduDTO getById(int id) {

        EducationalCenterEntity entity = eduRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Educational Center topilmadi!!!!"));

        return toDto(entity);
    }

    public List<EduDTO>getByName(String name) {
        List<EducationalCenterEntity> allByName = eduRepository.findAllByName(name);

        List<EduDTO> eduDTOList = new LinkedList<>();
        for (EducationalCenterEntity byName : allByName) {
            EduDTO dto = toDto(byName);
            eduDTOList.add(dto);
        }
        return eduDTOList;
    }

    public List<EduDTO>getByAddress(String address) {
        List<EducationalCenterEntity> allByAddress = eduRepository.findAllByAddress(address);

        List<EduDTO> eduDTOList = new LinkedList<>();
        for (EducationalCenterEntity byAddress : allByAddress) {
            EduDTO dto = toDto(byAddress);
            eduDTOList.add(dto);
        }
        return eduDTOList;
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
}

 