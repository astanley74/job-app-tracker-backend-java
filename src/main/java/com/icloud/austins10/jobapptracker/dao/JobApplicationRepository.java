package com.icloud.austins10.jobapptracker.dao;

import com.icloud.austins10.jobapptracker.entity.JobApplication;
import org.springframework.data.repository.CrudRepository;

public interface JobApplicationRepository extends CrudRepository<JobApplication, Integer> {

}
