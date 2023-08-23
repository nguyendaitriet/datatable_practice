package com.practice.datatable.model.repository;

import com.practice.datatable.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepo extends JpaRepository<Market, Integer> {
}
