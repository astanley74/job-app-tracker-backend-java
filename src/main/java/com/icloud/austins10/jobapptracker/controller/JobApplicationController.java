package com.icloud.austins10.jobapptracker.controller;

import com.icloud.austins10.jobapptracker.dao.JobApplicationRepository;
import com.icloud.austins10.jobapptracker.dao.UserRepository;
import com.icloud.austins10.jobapptracker.entity.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class JobApplicationController {
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jobapplications")
    public Iterable<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }
    // need GET ALL for one user
    @GetMapping(path="/users/{userId}/jobapplications")
    public Iterable<JobApplication> getAllJobApplicationsByUserId(@PathVariable int userId) {
        return jobApplicationRepository.findByUserId(userId);
    }

    // need POST
    @PostMapping(path="/users/{userId}/jobapplications")
    public JobApplication createJobApplication(@PathVariable int userId, @RequestBody JobApplication jobApplication) {
        return userRepository.findById(userId).map(user -> {
            jobApplication.setUser(user);
            jobApplication.setCreatedAt(LocalDate.now());
            return jobApplicationRepository.save(jobApplication);
        }).orElseThrow(() -> new IllegalArgumentException("UserId: " + userId + " not found"));
    }

    // need PUT
    @PutMapping(path="/users/{userId}/jobapplications/{jobAppId}")
    public JobApplication updateJobApplication(@PathVariable int userId, @PathVariable int jobAppId, @RequestBody JobApplication jobApplication) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("UserId: " + userId + " not found");
        }
        return jobApplicationRepository.findById(jobAppId).map(jobApplication1 -> {
            return jobApplicationRepository.save(jobApplication);
        }).orElseThrow(() -> new IllegalArgumentException("JobAppId: " + jobAppId + " not found"));
    }

    // need DELETE
    @DeleteMapping(path="/users/{userId}/jobapplications/{jobAppId}")
    public ResponseEntity<?> deleteJobApplication(@PathVariable int userId, @PathVariable int jobAppId) {
        return jobApplicationRepository.findById(jobAppId).map(jobApplication -> {
            jobApplicationRepository.delete(jobApplication);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new IllegalArgumentException("JobAppId: " + jobAppId + " not found"));
    }
}
