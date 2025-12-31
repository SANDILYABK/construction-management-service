package com.cm.admirable.dao;

import com.cm.admirable.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectsDAO extends JpaRepository<Projects ,Integer> {

}
