package com.shangchenhsieh.udemyCoursePPMT.repositories;

import org.springframework.stereotype.Repository;

import com.shangchenhsieh.udemyCoursePPMT.domain.User;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByUsername(String username);
    User getById(Long id);
}