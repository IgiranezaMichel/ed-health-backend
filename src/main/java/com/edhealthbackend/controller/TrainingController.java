package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
// import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputTraining;
import com.edhealthbackend.GqlModel.Paginations.TrainingPage;
import com.edhealthbackend.Model.Hospital;
import com.edhealthbackend.Model.Training;
import com.edhealthbackend.Repository.HospitalRepo;
import com.edhealthbackend.Repository.TrainingRepo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TrainingController {
    @Autowired
    private TrainingRepo trainingRepo;
    @Autowired
    private HospitalRepo hospitalRepo;

    @MutationMapping()
    public Training saveTraining(@Argument(name = "input") inputTraining data) {
        Hospital hospital = hospitalRepo.findById(data.getHospitalId()).orElse(null);
        if (hospital == null)
            return null;
        else
            return trainingRepo.save(new Training(data.getId(), data.getTitle(), data.getDescription(),
                    data.getPostDate(), data.getDeadline(), data.getTrainers(), false, false, null, hospital));
    }

    @MutationMapping()
    public String deleteTraining(@Argument long id) {
        try {
            Training Training = trainingRepo.findById(id).orElse(null);
            if (Training != null) {
                trainingRepo.deleteById(id);
                return "Accademic Deleted Sucessfully";
            } else
                return "Please Select Academic record";
        } catch (Exception e) {
            return "Error haappen";
        }
    }

    @QueryMapping()
    public Training findTrainingById(@Argument long id) {
        try {
            return trainingRepo.findById(id).orElse(null);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }

    }

    @QueryMapping()
    public List<Training> getAllTrainings() {
        return trainingRepo.findAll();
    }

    @QueryMapping()
    public TrainingPage trainingListPagination(@Argument(name = "pageNumber") int pageNumber,
            @Argument(name = "pageSize") int pageSize, @Argument(name = "sortBy") String sortBy,@Argument(name = "behaviour") String behaviour,
            @Argument(name = "status") Boolean status) {
        if (behaviour.equals("appending")) {
            Page<Training> appending = trainingRepo
                    .findAllByisApprovedByCnm(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)), status);
            return new TrainingPage(appending.getContent(), pageNumber, pageSize, trainingRepo.findAll().size());
        } else if (behaviour.equals("deny")) {
            Page<Training> appending = trainingRepo
                    .findAllByisDeniedByCnm(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)), status);
            return new TrainingPage(appending.getContent(), pageNumber, pageSize, trainingRepo.findAll().size());
        } else{
            Page<Training> denied = trainingRepo
                    .findAllByisApprovedByCnm(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)), status);
            return new TrainingPage(denied.getContent(), pageNumber, pageSize, trainingRepo.findAll().size());
        }
    }
}
