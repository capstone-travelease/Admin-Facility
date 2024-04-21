package com.capstone.FacilityAdmin.Controllers;

import com.capstone.FacilityAdmin.DTOs.RequestAdd;
import com.capstone.FacilityAdmin.DTOs.ResponseFacility;
import com.capstone.FacilityAdmin.DTOs.ResponseFacilityType;
import com.capstone.FacilityAdmin.DTOs.ResponseStatus;
import com.capstone.FacilityAdmin.Entities.FacilityType;
import com.capstone.FacilityAdmin.Services.FacilityService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/admin/api")
public class FacilityTypeController {
    private final FacilityService facilityService;

    public FacilityTypeController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/facility-type")
    public ResponseFacilityType getFacilityType(){
        return new ResponseFacilityType(
          200, facilityService.listType(),
          "Successful"
        );
    }

    @CrossOrigin(origins = "https://travelease-admin.netlify.app/", methods = {RequestMethod.POST})
    @PostMapping("/facility-type/add")
    public ResponseStatus addFacilityType(@RequestBody FacilityType name){
        var result = facilityService.addFacilitiesType(name);
        if(result == 1){
            return new ResponseStatus(
                    200,
                    "Add Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to add Facility Type",
                    "Failure"
            );
        }
    }

    @PostMapping("/facility-type/update/{id}")
    public ResponseStatus updateFacilities(@RequestBody FacilityType body, @PathVariable Integer id){
        Integer updateStatus = facilityService.updateFacilitiesType(body, id);
        if(updateStatus == 1){
            return new ResponseStatus(
                    200,
                    "Update Facility Type Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to update Facility Type",
                    "Failure"
            );
        }
    }

    @PostMapping("/facility-type/delete/{id}")
    public ResponseStatus deleteFacilities(@PathVariable Integer id){
        Integer updateStatus = facilityService.deleteFacilitiesType(id);
        if(updateStatus == 1){
            return new ResponseStatus(
                    200,
                    "Delete Facility Type " + id +" Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to delete facility type " + id,
                    "Failure"
            );
        }
    }
}
