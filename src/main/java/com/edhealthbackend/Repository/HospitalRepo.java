package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital,Long>{

}
