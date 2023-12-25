package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputSchool;
import com.edhealthbackend.Model.School;
import com.edhealthbackend.Repository.SchoolRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SchoolController {
@Autowired private SchoolRepo ac_ResultRepo;
@MutationMapping()
public School saveSchool(@Argument(name = "input")inputSchool data){
    return ac_ResultRepo.save(data.getData());
}

@MutationMapping()
public String deleteSchool(@Argument()long id){
    try {
        School School=ac_ResultRepo.findById(id).orElse(null);
      if(School!=null) {
        ac_ResultRepo.deleteById(id); 
        return "School Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public School findSchoolById(@Argument long id){
    try {
         return ac_ResultRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@QueryMapping()
public List<School> getAllSchools(){
    return ac_ResultRepo.findAll();
}
}
