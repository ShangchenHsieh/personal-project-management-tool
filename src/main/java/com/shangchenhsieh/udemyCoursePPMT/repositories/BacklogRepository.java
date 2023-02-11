package com.shangchenhsieh.udemyCoursePPMT.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shangchenhsieh.udemyCoursePPMT.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
    Backlog findByProjectIdentifier(String Identifier);
}
