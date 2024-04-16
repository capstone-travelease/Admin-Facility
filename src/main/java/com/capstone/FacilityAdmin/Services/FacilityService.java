package com.capstone.FacilityAdmin.Services;

import com.capstone.FacilityAdmin.DTOs.RequestAdd;
import com.capstone.FacilityAdmin.Entities.Facilities;
import com.capstone.FacilityAdmin.Repositories.FacilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private String FOLDER_PATH = "/facility_image/";


    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<Facilities> listFacilities(){
        List<Facilities> result = facilityRepository.findAll();
        return result;
    }

    @Transactional
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

    public Integer updateFacilities(RequestAdd body, Integer hotelId, MultipartFile image){
        try{
            facilityRepository.updateFacility(hotelId, body.getFacility_name(), body.getFacility_type(), image.getOriginalFilename());
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
