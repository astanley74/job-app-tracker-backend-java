package com.icloud.austins10.jobapptracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
