package com.capstone.FacilityAdmin.Repositories;

import com.capstone.FacilityAdmin.Entities.Facilities;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FacilityRepository extends JpaRepository<Facilities, Long> {
    @Modifying
    @Query(value = "INSERT INTO facilities(facility_name, facility_type, facility_image)" +
            "VALUES(?1,?2,?3)", nativeQuery = true)
    void addFacility(String facilityName, String facilityType, String facilityImage);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE facilities SET \n" +
            "facility_name = ?2, facility_type =?3, facility_image = ?4\n" +
            "WHERE facility_id = ?1", nativeQuery = true)
    void updateFacility(Integer id, String facilityName, String facilityType, String facilityImage);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM facilities WHERE facility_id = ?1", nativeQuery = true)
    void deleteFacility(Integer id);
}
