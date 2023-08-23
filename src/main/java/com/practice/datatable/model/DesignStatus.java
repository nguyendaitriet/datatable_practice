package com.practice.datatable.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "design_status")
public class DesignStatus extends SimpleModel {
    public DesignStatus(String name) {
        super(name);
    }
}