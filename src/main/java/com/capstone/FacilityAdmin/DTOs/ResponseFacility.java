package com.capstone.FacilityAdmin.DTOs;

import com.capstone.FacilityAdmin.Entities.Facilities;

import java.util.List;

public class ResponseFacility {
    private Integer code;
    private List<FacilityDTO> data;
    private String message;

    public ResponseFacility(Integer code, List<FacilityDTO> data, String message) {
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

    public List<FacilityDTO> getData() {
        return data;
    }

    public void setData(List<FacilityDTO> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseFacility{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
