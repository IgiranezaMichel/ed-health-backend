package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.Certificate;

public interface CertificateRepo extends JpaRepository<Certificate,Long>{

}
