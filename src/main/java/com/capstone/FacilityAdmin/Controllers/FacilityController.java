package com.capstone.FacilityAdmin.Controllers;

import com.capstone.FacilityAdmin.DTOs.RequestAdd;
import com.capstone.FacilityAdmin.DTOs.ResponseFacility;
import com.capstone.FacilityAdmin.DTOs.ResponseStatus;
import com.capstone.FacilityAdmin.Entities.Facilities;
import com.capstone.FacilityAdmin.Services.FacilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin/api")
public class FacilityController {
    public final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/facilities")
    public ResponseFacility getFacilities(){
        return new ResponseFacility(
                200,
                facilityService.listFacilities(),
                "Successful"
        );
    }

    @PostMapping("/facility/add")
    public ResponseStatus addFacilities(@RequestBody RequestAdd request){
        Integer addStatus = facilityService.addFacilities(request);
        if(addStatus == 1){
            return new ResponseStatus(
                    200,
                    "Add Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to add Facility",
                    "Failure"
            );
        }
    }

    @PostMapping("/facility/update/{id}")
    public ResponseStatus updateFacilities(@RequestBody RequestAdd body, @PathVariable Integer id){
        Integer updateStatus = facilityService.updateFacilities(body, id);
        if(updateStatus == 1){
            return new ResponseStatus(
                    200,
                    "Update Facility Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to update Facility",
                    "Failure"
            );
        }
    }

    @PostMapping("/facility/delete/{id}")
    public ResponseStatus deleteFacilities(@PathVariable Integer id){
        Integer updateStatus = facilityService.deleteFacilities(id);
        if(updateStatus == 1){
            return new ResponseStatus(
                    200,
                    "Delete Facility " + id +" Successful",
                    "Successful"
            );
        }
        else{
            return new ResponseStatus(
                    500,
                    "Fail to delete facility " + id,
                    "Failure"
            );
        }
    }
}
