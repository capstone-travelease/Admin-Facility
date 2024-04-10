package com.capstone.FacilityAdmin.DTOs;

import com.capstone.FacilityAdmin.Entities.Facilities;

import java.util.List;

public class ResponseFacility {
    private Integer code;
    private List<Facilities> data;
    private String message;

    public ResponseFacility(Integer code, List<Facilities> data, String message) {
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

    public List<Facilities> getData() {
        return data;
    }

    public void setData(List<Facilities> data) {
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
