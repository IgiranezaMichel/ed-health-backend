package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.Model.AcademicAnualResult;
import com.edhealthbackend.Repository.AcademicAnualResultRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AcademicAnualResultController {
@Autowired private AcademicAnualResultRepo ac_ResultRepo;
@MutationMapping()
public AcademicAnualResult saveAccademicResult(@Argument(name = "input")AcademicAnualResult data){
    return ac_ResultRepo.save(data);
}
@MutationMapping()
public AcademicAnualResult findById(@Argument(name = "input")long data){
    try {
         return ac_ResultRepo.findById(data).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@MutationMapping()
public String deleteAccademicResult(@Argument()long data){
    try {
        AcademicAnualResult academicAnualResult=ac_ResultRepo.findById(data).orElse(null);
      if(academicAnualResult!=null) {
        ac_ResultRepo.deleteById(data); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public AcademicAnualResult findAcademicAnualResultById(@Argument() long data){
return ac_ResultRepo.findById(data).orElse(null);
}
@QueryMapping()
public List<AcademicAnualResult> getAllAnnualResult(){
    return ac_ResultRepo.findAll();
}
}
