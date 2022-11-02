package com.shangchenhsieh.udemyCoursePPMT.repositories;

import com.shangchenhsieh.udemyCoursePPMT.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
