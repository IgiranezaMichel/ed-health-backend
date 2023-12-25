package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.Model.Hospital;
import com.edhealthbackend.Repository.HospitalRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HospitalController {
@Autowired private HospitalRepo hospitalRepo;
@MutationMapping()
public Hospital saveHospital(@Argument(name = "input")Hospital data){
    return hospitalRepo.save(data);
}
@MutationMapping()
public String deleteHospital(@Argument()long data){
    try {
        Hospital Hospital=hospitalRepo.findById(data).orElse(null);
      if(Hospital!=null) {
        hospitalRepo.deleteById(data); 
        return "Hospital Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        log.info(e+"");
        return "Error haappen";
    }
}

@QueryMapping()
public Hospital findHospitalById(@Argument() long id){
return hospitalRepo.findById(id).orElse(null);
}
@QueryMapping()
public List<Hospital> getAllHospitals(){
    return hospitalRepo.findAll();
}
}
