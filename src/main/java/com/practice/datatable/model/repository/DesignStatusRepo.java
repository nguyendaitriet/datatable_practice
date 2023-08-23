package com.practice.datatable.model.repository;

import com.practice.datatable.model.DesignStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignStatusRepo extends JpaRepository<DesignStatus, Integer> {
}
