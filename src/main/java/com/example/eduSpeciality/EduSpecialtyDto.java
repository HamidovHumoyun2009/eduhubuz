package com.example.eduSpeciality;


import com.example.educational_center.EducationalCenterEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EduSpecialtyDto {
    private Integer id;
    private String name;
    private String info;
    private int edu_center_id;
}
