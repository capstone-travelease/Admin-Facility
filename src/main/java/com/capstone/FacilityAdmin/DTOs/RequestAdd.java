package com.capstone.FacilityAdmin.DTOs;

public class RequestAdd {
    private String facility_name;
    private Integer facility_type;

    public RequestAdd(String facility_name, Integer facility_type) {
        this.facility_name = facility_name;
        this.facility_type = facility_type;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public Integer getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(Integer facility_type) {
        this.facility_type = facility_type;
    }

    @Override
    public String toString() {
        return "RequestAdd{" +
                "facility_name='" + facility_name + '\'' +
                ", facility_type='" + facility_type + '\'' +
                '}';
    }
}
