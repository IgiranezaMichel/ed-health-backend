package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputLocation;
import com.edhealthbackend.Model.Location;
import com.edhealthbackend.Repository.LocationRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LocationController {
@Autowired private LocationRepo ac_ResultRepo;
@MutationMapping()
public Location saveLocation(@Argument(name = "input")inputLocation data){
    return ac_ResultRepo.save(data.getData());
}

@MutationMapping()
public String deleteLocation(@Argument long id){
    try {
        Location Location=ac_ResultRepo.findById(id).orElse(null);
      if(Location!=null) {
        ac_ResultRepo.deleteById(id); 
        return "Location Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}

@QueryMapping()
public Location findLocationById(@Argument long id){
    try {
         return ac_ResultRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@QueryMapping()
public List<Location> getAllLocations(){
    return ac_ResultRepo.findAll();
}
}
