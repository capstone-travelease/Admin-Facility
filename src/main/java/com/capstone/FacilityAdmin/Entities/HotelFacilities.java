package com.capstone.FacilityAdmin.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class HotelFacilities {
    @Column(name = "id_hotel")
    private Integer id_hotel;
    @Column(name = "id_facility")
    private Integer id_facility;
    @Id
    private Integer hotel_facilities_id;

    public HotelFacilities() {
    }

    public HotelFacilities(Integer id_hotel, Integer id_facility, Integer hotel_facilities_id) {
        this.id_hotel = id_hotel;
        this.id_facility = id_facility;
        this.hotel_facilities_id = hotel_facilities_id;
    }

    public Integer getid_hotel() {
        return id_hotel;
    }

    public void setid_hotel(Integer id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Integer getid_facility() {
        return id_facility;
    }

    public void setid_facility(Integer id_facility) {
        this.id_facility = id_facility;
    }

    public Integer gethotel_facilities_id() {
        return hotel_facilities_id;
    }

    public void sethotel_facilities_id(Integer hotel_facilities_id) {
        this.hotel_facilities_id = hotel_facilities_id;
    }
}
