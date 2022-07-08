package com.icloud.austins10.jobapptracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String firstName;

    String lastName;

    String emailAddress;

    String password;

    LocalDate createdAt;

    LocalDate updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<JobApplication> jobApplications;
}
