package com.capstone.FacilityAdmin.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class RoomFacilities {
    @Column(name = "room_id")
    private Integer room_id;
    @Column(name = "facility_id")
    private Integer facility_id;
    @Id
    private Integer room_facilities_id;

    public RoomFacilities() {
    }

    public RoomFacilities(Integer room_id, Integer facility_id, Integer room_facilities_id) {
        this.room_id = room_id;
        this.facility_id = facility_id;
        this.room_facilities_id = room_facilities_id;
    }

    public Integer getroom_id() {
        return room_id;
    }

    public void setroom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(Integer facility_id) {
        this.facility_id = facility_id;
    }

    public Integer getRoom_facilities_id() {
        return room_facilities_id;
    }

    public void setRoom_facilities_id(Integer room_facilities_id) {
        this.room_facilities_id = room_facilities_id;
    }
}
