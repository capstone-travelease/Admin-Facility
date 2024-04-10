package com.capstone.FacilityAdmin.DTOs;

public class RequestAdd {
    private String facility_name;
    private String facility_type;
    private String facility_image;

    public RequestAdd(String facility_name, String facility_type, String facility_image) {
        this.facility_name = facility_name;
        this.facility_type = facility_type;
        this.facility_image = facility_image;
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
        return "RequestAdd{" +
                "facility_name='" + facility_name + '\'' +
                ", facility_type='" + facility_type + '\'' +
                ", facility_image='" + facility_image + '\'' +
                '}';
    }
}
