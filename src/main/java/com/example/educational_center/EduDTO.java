package com.example.educational_center;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EduDTO {
    private int id;
    private String name;
    private String address;
    private String contactInfo;
    private String info;
    private EduCenterType eduCenterType;
}
