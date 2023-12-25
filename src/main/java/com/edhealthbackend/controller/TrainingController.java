package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
// import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputTraining;
import com.edhealthbackend.Model.Training;
import com.edhealthbackend.Repository.TrainingRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class TrainingController {
@Autowired private TrainingRepo ac_ResultRepo;
@MutationMapping()
public Training saveTraining(@Argument(name = "input")inputTraining data){
    return ac_ResultRepo.save(data.getData());
}

@MutationMapping()
public String deleteTraining(@Argument long id){
    try {
        Training Training=ac_ResultRepo.findById(id).orElse(null);
      if(Training!=null) {
        ac_ResultRepo.deleteById(id); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public Training findTrainingById(@Argument long id){
    try {
         return ac_ResultRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@QueryMapping()
public List<Training> getAllTrainings(){
    return ac_ResultRepo.findAll();
}
}
