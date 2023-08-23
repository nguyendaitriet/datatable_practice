package com.practice.datatable.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "desgin_brands")
public class DesignBrand extends SimpleModel {
    public DesignBrand(String name) {
        super(name);
    }
}