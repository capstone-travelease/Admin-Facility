package com.capstone.FacilityAdmin.DTOs;

import jakarta.persistence.Column;

public class FacilityDTO {
    private Integer facility_id;
    private String facility_name;
    private String facility_type;
    private String facility_image;

    public FacilityDTO(Integer facility_id, String facility_name, String facility_type, String facility_image) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.facility_type = facility_type;
        this.facility_image = facility_image;
    }

    public Integer getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(Integer facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getFacility_image() {
        return facility_image;
    }

    public void setFacility_image(String facility_image) {
        this.facility_image = facility_image;
    }

    @Override
    public String toString() {
        return "FacilityDTO{" +
                "facility_id=" + facility_id +
                ", facility_name='" + facility_name + '\'' +
                ", facility_type='" + facility_type + '\'' +
                ", facility_image='" + facility_image + '\'' +
                '}';
    }
}
