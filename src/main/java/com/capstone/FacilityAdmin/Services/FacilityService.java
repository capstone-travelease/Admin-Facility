package com.capstone.FacilityAdmin.Services;

import com.capstone.FacilityAdmin.DTOs.RequestAdd;
import com.capstone.FacilityAdmin.Entities.Facilities;
import com.capstone.FacilityAdmin.Entities.FacilityType;
import com.capstone.FacilityAdmin.Repositories.FacilityRepository;
import com.capstone.FacilityAdmin.Repositories.FacilityTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final FacilityTypeRepository facilityTypeRepository;

    private String FOLDER_PATH = "/facility_images/";

    public FacilityService(FacilityRepository facilityRepository, FacilityTypeRepository facilityTypeRepository) {
        this.facilityRepository = facilityRepository;
        this.facilityTypeRepository = facilityTypeRepository;
    }

    /* Get Facilities */
    public List<Facilities> listFacilities(){
        List<Facilities> result = facilityRepository.findAll();
        return result;
    }

    public List<FacilityType> listType(){
        List<FacilityType> result = facilityTypeRepository.findAll();
        return result;
    }

    /* Add Facilities */
    public Integer addFacilities(RequestAdd request, MultipartFile image){
        try {
            // the path of folder has existed in local
            String fileUrl = FOLDER_PATH+image.getOriginalFilename();
            // transfer from data of api to folder
            image.transferTo(new File(fileUrl));
            facilityRepository.addFacility(request.getFacility_name(), request.getFacility_type(), fileUrl);
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }

    public Integer addFacilitiesType(FacilityType name){
        try {
            facilityTypeRepository.addFacilityType(name.getFacility_type_name());
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }

    /* Update Facilities */
    public Integer updateFacilities(RequestAdd body, Integer hotelId, MultipartFile image){
        String fileUrl = FOLDER_PATH+image.getOriginalFilename();
        try{
            image.transferTo(new File(fileUrl));
            facilityRepository.updateFacility(hotelId, body.getFacility_name(), body.getFacility_type(), fileUrl);
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }

    public Integer updateFacilitiesType(FacilityType name, Integer id){
        try{
            facilityTypeRepository.updateFacilityType(id, name.getFacility_type_name());
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }

    /* Delete Facilities */
    public Integer deleteFacilities(Integer facilityId){
        try{
            facilityRepository.deleteFacility(facilityId);
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }

    public Integer deleteFacilitiesType(Integer facilityId){
        try{
            facilityTypeRepository.deleteFacilityType(facilityId);
            return 1;
        }
        catch (Exception error){
            System.out.println(error);
            return 2;
        }
    }
}
