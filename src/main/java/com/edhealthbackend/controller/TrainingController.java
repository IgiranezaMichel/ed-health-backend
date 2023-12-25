package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.edhealthbackend.Model.Training;
import com.edhealthbackend.Repository.TrainingRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class TrainingController {
@Autowired private TrainingRepo ac_ResultRepo;
@MutationMapping()
public Training saveAccademicResult(@Argument(name = "input")Training data){
    return ac_ResultRepo.save(data);
}
@MutationMapping()
public Training findById(@Argument(name = "input")long data){
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
        Training Training=ac_ResultRepo.findById(data).orElse(null);
      if(Training!=null) {
        ac_ResultRepo.deleteById(data); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public Training findTrainingById(@Argument() long data){
return ac_ResultRepo.findById(data).orElse(null);
}
@QueryMapping()
public List<Training> getAllTrainings(){
    return ac_ResultRepo.findAll();
}
}
