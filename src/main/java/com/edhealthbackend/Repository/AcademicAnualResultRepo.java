package com.edhealthbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edhealthbackend.Model.AcademicAnualResult;

@Repository
public interface AcademicAnualResultRepo extends JpaRepository<AcademicAnualResult, Long> {

}
