package com.example.eduSpeciality;

import com.example.components.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EduSpecialityService {

    @Autowired
    private EduSpecialityRepository eduSpecialityRepository;

    public ApiResponse create(EduSpecialtyDto dto) {
        EduSpecialityEntity eduSpeciality = new EduSpecialityEntity();
        eduSpeciality.setName(dto.getName());
        eduSpeciality.setInfo(dto.getInfo());
        eduSpeciality.setEduCenterId(dto.getEduCenterId());

        eduSpecialityRepository.save(eduSpeciality);

        return new ApiResponse(true, "Muvaffaqiyatli yaratildi!", eduSpeciality);
    }

    public List<EduSpecialityEntity> getAll() {
        List<EduSpecialityEntity> all = eduSpecialityRepository.findAll();
        return all;
    }

    public ApiResponse getById(int id) {
        EduSpecialityEntity eduSpecialityEntity = eduSpecialityRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Topilmadi!!!"));

        return new ApiResponse(true, toDto(eduSpecialityEntity));

    }

    private EduSpecialtyDto toDto(EduSpecialityEntity eduSpecialityEntity) {
        EduSpecialtyDto eduSpecialtyDto = new EduSpecialtyDto();
        eduSpecialtyDto.setId(eduSpecialtyDto.getId());
        eduSpecialtyDto.setName(eduSpecialityEntity.getName());
        eduSpecialtyDto.setInfo(eduSpecialityEntity.getInfo());
        eduSpecialtyDto.setEduCenterId(eduSpecialityEntity.getEduCenterId());
        return eduSpecialtyDto;
    }

    public List<EduSpecialtyDto> getByName(String name) {
        List<EduSpecialityEntity> allByName = eduSpecialityRepository.findAllByName(name);
        List<EduSpecialtyDto> eduSpecialtyDtos = new ArrayList<>();
        allByName.forEach(eduSpecialityEntity -> {
            EduSpecialtyDto eduSpecialtyDto = toDto(eduSpecialityEntity);
            eduSpecialtyDtos.add(eduSpecialtyDto);
        });
        return eduSpecialtyDtos;
    }

    public List<EduSpecialtyDto> getAllByEduCenterId(int eduCenterId) {
        List<EduSpecialityEntity> allByEducationalCenterId = eduSpecialityRepository
                .findAllByEducationalCenterId(eduCenterId);

        List<EduSpecialtyDto> eduSpecialtyDtos = new ArrayList<>();

        allByEducationalCenterId.forEach(eduSpecialityEntity -> {
            EduSpecialtyDto eduSpecialtyDto = toDto(eduSpecialityEntity);
            eduSpecialtyDtos.add(eduSpecialtyDto);
        });
        return eduSpecialtyDtos;

    }

    public ApiResponse deleteById(int id) {

        EduSpecialityEntity eduSpecialityEntity = get(id);
        eduSpecialityRepository.deleteById(id);
        return new ApiResponse(true, "O'chdi");
    }

    public ApiResponse updateById(int id, EduSpecialtyDto dto) {

        EduSpecialityEntity eduSpeciality = get(id);

        eduSpeciality.setName(dto.getName());
        eduSpeciality.setInfo(dto.getInfo());
        eduSpeciality.setEduSpecialityId(dto.getEduCenterId());

        eduSpecialityRepository.save(eduSpeciality);

        return new ApiResponse(true,
                "Muvaffaqiyatli yangilandi!", eduSpeciality);
    }

    private EduSpecialityEntity get(int id) {
        return eduSpecialityRepository.findById(id).orElseThrow(() -> new RuntimeException("Topilmadi!"));
    }
}
