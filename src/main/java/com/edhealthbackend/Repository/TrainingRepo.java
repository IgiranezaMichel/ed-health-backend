package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edhealthbackend.Model.Training;

public interface TrainingRepo extends JpaRepository<Training,Long>{

}
