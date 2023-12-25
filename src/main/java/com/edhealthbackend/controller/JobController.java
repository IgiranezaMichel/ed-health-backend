package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.Model.Job;
import com.edhealthbackend.Repository.JobRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class JobController {
@Autowired private JobRepo ac_ResultRepo;
@MutationMapping()
public Job saveAccademicResult(@Argument(name = "input")Job data){
    return ac_ResultRepo.save(data);
}
@MutationMapping()
public Job findById(@Argument(name = "input")long data){
    try {
         return ac_ResultRepo.findById(data).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@MutationMapping()
public String deleteJob(@Argument()long data){
    try {
        Job Job=ac_ResultRepo.findById(data).orElse(null);
      if(Job!=null) {
        ac_ResultRepo.deleteById(data); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public Job findJobById(@Argument() long data){
return ac_ResultRepo.findById(data).orElse(null);
}
@QueryMapping()
public List<Job> getAllJobs(){
    return ac_ResultRepo.findAll();
}
}
