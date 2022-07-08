package com.icloud.austins10.jobapptracker.dao;

import com.icloud.austins10.jobapptracker.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserById(int id);
}
