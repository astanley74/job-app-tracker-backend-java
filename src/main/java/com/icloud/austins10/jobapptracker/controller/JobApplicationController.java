package com.icloud.austins10.jobapptracker.controller;

import com.icloud.austins10.jobapptracker.dao.JobApplicationRepository;
import com.icloud.austins10.jobapptracker.entity.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JobApplicationController {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;
    // need GET ALL
    @GetMapping(path="/jobapplications")
    public @ResponseBody
    Iterable<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    };

    // need GET ONE

    // need POST

    // need PUT

    // need DELETE


}
