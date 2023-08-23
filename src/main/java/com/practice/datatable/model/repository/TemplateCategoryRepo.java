package com.practice.datatable.model.repository;

import com.practice.datatable.model.TemplateCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateCategoryRepo extends JpaRepository<TemplateCategory, Integer> {
}
