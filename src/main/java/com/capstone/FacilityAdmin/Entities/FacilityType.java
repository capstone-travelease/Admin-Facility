package com.capstone.FacilityAdmin.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class FacilityType {
    @Id
    private Integer facility_type_id;
    private String facility_type_name;

    public FacilityType() {
    }

    public FacilityType(String facility_type_name) {
        this.facility_type_name = facility_type_name;
    }

    public FacilityType(Integer facility_type_id, String facility_type_name) {
        this.facility_type_id = facility_type_id;
        this.facility_type_name = facility_type_name;
    }

    public Integer getFacility_type_id() {
        return facility_type_id;
    }

    public void setFacility_type_id(Integer facility_type_id) {
        this.facility_type_id = facility_type_id;
    }

    public String getFacility_type_name() {
        return facility_type_name;
    }

    public void setFacility_type_name(String facility_type_name) {
        this.facility_type_name = facility_type_name;
    }
}
