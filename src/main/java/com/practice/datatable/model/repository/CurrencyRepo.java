package com.practice.datatable.model.repository;

import com.practice.datatable.model.Currency;
import com.practice.datatable.model.DesignBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Integer> {
}
