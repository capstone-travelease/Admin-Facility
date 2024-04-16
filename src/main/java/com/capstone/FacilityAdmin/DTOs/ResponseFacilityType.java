package com.capstone.FacilityAdmin.DTOs;

import com.capstone.FacilityAdmin.Entities.Facilities;
import com.capstone.FacilityAdmin.Entities.FacilityType;

import java.util.List;

public class ResponseFacilityType {
    private Integer code;
    private List<FacilityType> data;
    private String message;

    public ResponseFacilityType(Integer code, List<FacilityType> data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<FacilityType> getData() {
        return data;
    }

    public void setData(List<FacilityType> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
