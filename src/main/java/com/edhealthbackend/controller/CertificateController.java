package com.edhealthbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.inputCertificate;
import com.edhealthbackend.Model.Certificate;
import com.edhealthbackend.Repository.CertificateRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class CertificateController {
@Autowired private CertificateRepo certificateRepo;
@MutationMapping()
public Certificate saveCertificate(@Argument(name = "input")inputCertificate data){
    return certificateRepo.save(data.getData());
}   
@MutationMapping()
public String deleteCertificate(@Argument()long id){
    try {
        Certificate Certificate=certificateRepo.findById(id).orElse(null);
      if(Certificate!=null) {
        certificateRepo.deleteById(id); 
        return "Certificate Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public Certificate findCertificateById(@Argument long id){
    try {
         return certificateRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
}
@QueryMapping()
public List<Certificate> getAllCertificate(){
    return certificateRepo.findAll();
}
}
