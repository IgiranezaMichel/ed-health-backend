package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.Job;

public interface JobRepo extends JpaRepository<Job,Long>{

}
