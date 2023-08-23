package com.practice.datatable.model.repository;

import com.practice.datatable.model.TemplateStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateStandardRepo extends JpaRepository<TemplateStandard, Integer> {
}
