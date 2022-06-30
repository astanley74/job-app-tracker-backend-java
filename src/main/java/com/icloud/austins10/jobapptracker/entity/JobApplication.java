package com.icloud.austins10.jobapptracker.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String companyName;

    private String dateOfApplication;

    private String position;

    private Boolean applicationStatus;

    private String currentStage;

    private String notes;

    private LocalDate createdAt;

    private LocalDate updatedAt;
}
