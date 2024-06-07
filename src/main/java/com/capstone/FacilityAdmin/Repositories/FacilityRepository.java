package com.capstone.FacilityAdmin.Repositories;

import com.capstone.FacilityAdmin.DTOs.FacilityDTO;
import com.capstone.FacilityAdmin.Entities.Facilities;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facilities, Long> {
    @Query("SELECT new com.capstone.FacilityAdmin.DTOs.FacilityDTO(f.facility_id, f.facility_name, ft.facility_type_name, f.facility_image) FROM Facilities f\n" +
            "INNER JOIN FacilityType ft ON ft.facility_type_id = f.facility_type \n" +
            "ORDER BY f.facility_id")
    List<FacilityDTO> listFacilities();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO facilities(facility_name, facility_type, facility_image)" +
            "VALUES(?1,?2,?3)", nativeQuery = true)
    void addFacility(String facilityName, Integer facilityType, String facilityImage);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE facilities SET \n" +
            "facility_name = ?2, facility_type =?3, facility_image = ?4\n" +
            "WHERE facility_id = ?1", nativeQuery = true)
    void updateFacility(Integer id, String facilityName, Integer facilityType, String facilityImage);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM facilities WHERE facility_id = ?1", nativeQuery = true)
    void deleteFacility(Integer id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hotel_facilities WHERE id_facility = ?1", nativeQuery = true)
    void deleteHotelFacility(Integer id);
}
