package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.Model.School;
import com.edhealthbackend.Repository.SchoolRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SchoolController {
@Autowired private SchoolRepo ac_ResultRepo;
@MutationMapping()
public School saveSchool(@Argument(name = "input")School data){
    return ac_ResultRepo.save(data);
}
@MutationMapping()
public School findById(@Argument(name = "input")long data){
    try {
         return ac_ResultRepo.findById(data).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@MutationMapping()
public String deleteSchool(@Argument()long data){
    try {
        School School=ac_ResultRepo.findById(data).orElse(null);
      if(School!=null) {
        ac_ResultRepo.deleteById(data); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public School findSchoolById(@Argument() long data){
return ac_ResultRepo.findById(data).orElse(null);
}
@QueryMapping()
public List<School> getAllSchools(){
    return ac_ResultRepo.findAll();
}
}
