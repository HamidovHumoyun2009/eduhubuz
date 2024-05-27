package com.example.educational_center;

import com.example.eduSpeciality.EduSpecialityEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "educational_center")

public class EducationalCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contactInfo;

    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EduSpecialityEntity> eduSpecialityEntities;
}