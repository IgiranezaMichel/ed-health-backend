package com.edhealthbackend.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.Training;

public interface TrainingRepo extends JpaRepository<Training,Long>{
    Page<Training> findAllByisApprovedByCnm(PageRequest of, Boolean status);
    Page<Training> findAllByisDeniedByCnm(PageRequest of, Boolean status);

}
