package com.example.eduSpeciality;

import com.example.educational_center.EducationalCenterEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "edu_speciality")
public class EduSpecialityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eduSpecialityId;

    @Column(name = "name")
    private String name;

    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edu_center_id",
            insertable = false,
            updatable = false)
    private EducationalCenterEntity educationalCenter;

    @Column(name = "edu_center_id")
    private Integer eduCenterId;
}
