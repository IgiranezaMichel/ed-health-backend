package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.Model.Certificate;
import com.edhealthbackend.Repository.CertificateRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class CertificateController {
@Autowired private CertificateRepo certificateRepo;
@MutationMapping()
public Certificate saveCertificate(@Argument(name = "input")Certificate data){
    return certificateRepo.save(data);
}
@MutationMapping()
public Certificate findById(@Argument(name = "input")long data){
    try {
         return certificateRepo.findById(data).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@MutationMapping()
public String deleteCertificate(@Argument()long data){
    try {
        Certificate Certificate=certificateRepo.findById(data).orElse(null);
      if(Certificate!=null) {
        certificateRepo.deleteById(data); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public Certificate findCertificateById(@Argument() long data){
return certificateRepo.findById(data).orElse(null);
}
@QueryMapping()
public List<Certificate> getAllCertificates(){
    return certificateRepo.findAll();
}
}
