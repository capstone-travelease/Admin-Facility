package com.capstone.FacilityAdmin.Services;

import com.capstone.FacilityAdmin.DTOs.RequestAdd;
import com.capstone.FacilityAdmin.Entities.Facilities;
import com.capstone.FacilityAdmin.Repositories.FacilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService {
    private final FacilityRepository facilityRepository;

    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facilities> listFacilities(){
        List<Facilities> result = facilityRepository.findAll();
        return result;
    }

    @Transactional
    public Integer addFacilities(RequestAdd request){
        try {
            facilityRepository.addFacility(request.getFacility_name(), request.getFacility_type(), request.getFacility_image());
            return 1;
        }
        catch (Exception error){
            return 2;
        }
    }

    public Integer updateFacilities(RequestAdd body, Integer hotelId){
        try{
            facilityRepository.updateFacility(hotelId, body.getFacility_name(), body.getFacility_type(), body.getFacility_image());
            return 1;
        }
        catch (Exception error){
            return 2;
        }
    }

    public Integer deleteFacilities(Integer hotelId){
        try{
            facilityRepository.deleteFacility(hotelId);
            return 1;
        }
        catch (Exception error){
            return 2;
        }
    }
}
