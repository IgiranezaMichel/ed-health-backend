package com.edhealthbackend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.edhealthbackend.GqlModel.inputAcademicAnualResult;
import com.edhealthbackend.Model.AcademicAnualResult;
import com.edhealthbackend.Repository.AcademicAnualResultRepo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AcademicAnualResultController {
    @Autowired
    private AcademicAnualResultRepo ac_ResultRepo;

    @MutationMapping()
    public AcademicAnualResult saveAcademicResult(@Argument(name = "input") inputAcademicAnualResult data) {
        return ac_ResultRepo.save(data.getData());
    }

    @MutationMapping()
    public String deleteAcademicResult(@Argument long id) {
        try {
            AcademicAnualResult academicAnualResult = ac_ResultRepo.findById(id).orElse(null);
            if (academicAnualResult != null) {
                ac_ResultRepo.deleteById(id);
                return "Accademic Deleted Sucessfully";
            } else
                return "Please Select Academic record";
        } catch (Exception e) {
            return "Error haappen";
        }
    }

    @QueryMapping()
    public AcademicAnualResult findAcademicResultById(@Argument long data) {
        try {
            return ac_ResultRepo.findById(data).orElse(null);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }

    }

    @QueryMapping()
    public List<AcademicAnualResult> getAllAnnualResult() {
        return ac_ResultRepo.findAll();
    }
}
