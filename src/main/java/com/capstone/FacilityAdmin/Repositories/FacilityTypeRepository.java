package com.capstone.FacilityAdmin.Repositories;

import com.capstone.FacilityAdmin.Entities.FacilityType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO facility_type(facility_type_name)" +
            "VALUES(?1)", nativeQuery = true)
    void addFacilityType(String facilityTypeName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE facility_type SET \n" +
            "facility_type_name = ?2\n" +
            "WHERE facility_type_id = ?1", nativeQuery = true)
    void updateFacilityType(Integer id, String facilityTypeName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM facility_type WHERE facility_type_id = ?1", nativeQuery = true)
    void deleteFacilityType(Integer id);
}

