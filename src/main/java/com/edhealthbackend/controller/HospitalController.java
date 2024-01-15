package com.edhealthbackend.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputHospital;
import com.edhealthbackend.GqlModel.Paginations.HospitalPage;
import com.edhealthbackend.Model.Hospital;
import com.edhealthbackend.Model.Location;
import com.edhealthbackend.Repository.HospitalRepo;
import com.edhealthbackend.Repository.LocationRepo;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HospitalController {
@Autowired private HospitalRepo hospitalRepo;
@Autowired private LocationRepo locationRepo;
@MutationMapping()
public Hospital saveHospital(@Argument(name = "input")inputHospital data){
    try {
      Location location= locationRepo.findById(data.getLocationId()).orElse(null);
       if(location!=null)
         return hospitalRepo.save(new Hospital(data.getId(), data.getName(), data.getLogo(), LocalDateTime.now(),location));
    } catch (Exception e) {
       log.info(e.getMessage());
    }
    return null;
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
@QueryMapping()
public HospitalPage hospitaListPagination( @Argument(name = "pageNumber") int pageNumber,@Argument(name = "pageSize") int pageSize,@Argument(name = "sortBy") String sortBy){
   Page<Hospital>hospitalList= hospitalRepo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)));
   return new HospitalPage(hospitalList.getContent(), hospitalList.getNumber(), hospitalList.getTotalPages(),hospitalRepo.findAll().size());
}
}
