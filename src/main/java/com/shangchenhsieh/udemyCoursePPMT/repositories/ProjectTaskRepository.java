package com.shangchenhsieh.udemyCoursePPMT.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.shangchenhsieh.udemyCoursePPMT.domain.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

}
