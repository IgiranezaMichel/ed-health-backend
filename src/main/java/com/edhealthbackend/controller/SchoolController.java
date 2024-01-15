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

import com.edhealthbackend.GqlModel.inputSchool;
import com.edhealthbackend.GqlModel.Paginations.SchoolPage;
import com.edhealthbackend.Model.Location;
import com.edhealthbackend.Model.School;
import com.edhealthbackend.Model.User;
import com.edhealthbackend.Repository.LocationRepo;
import com.edhealthbackend.Repository.SchoolRepo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SchoolController {
    @Autowired
    private SchoolRepo schoolRepo;
    @Autowired
    private LocationRepo locationRepo;

    @MutationMapping()
    public School saveSchool(@Argument(name = "input") inputSchool data) {
        Location location = new Location();
        try {
            location = locationRepo.findById(data.getLocationId()).orElse(null);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
        return schoolRepo.save(new School(data.getId(), data.getName(), data.getLogo(), LocalDateTime.now(), location));
    }

    @MutationMapping()
    public String deleteSchool(@Argument() long id) {
        try {
            School School = schoolRepo.findById(id).orElse(null);
            if (School != null) {
                schoolRepo.deleteById(id);
                return "School Deleted Sucessfully";
            } else
                return "Please Select Academic record";
        } catch (Exception e) {
            return "Error haappen";
        }
    }

    @QueryMapping()
    public School findSchoolById(@Argument long id) {
        try {
            return schoolRepo.findById(id).orElse(null);
        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }

    }

    @QueryMapping()
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @QueryMapping()
    public SchoolPage schoolListPagination(@Argument(name = "pageNumber") int pageNumber,
            @Argument(name = "pageSize") int pageSize, @Argument(name = "sortBy") String sortBy) {
        Page<School> schooPage = schoolRepo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy)));
        return new SchoolPage(schooPage.getContent(), schooPage.getNumber(), schooPage.getTotalPages(),
                schoolRepo.findAll().size());
    }

    @QueryMapping()
    public List<User> searchStudent(@Argument(name = "schoolId") long schoolId,
            @Argument(name = "search") String search) {
        try {
            School findSchool = schoolRepo.findById(schoolId).orElse(null);
            if (findSchool != null) {
                List<User> findUser = findSchool.getUserList()
                        .stream().filter(
                                user -> ((user.getName().toLowerCase().contains(search.toLowerCase()))
                                        || (user.getEmail().toLowerCase().contains(search.toLowerCase()))
                                        || (user.getPhoneNumber().toLowerCase().contains(search.toLowerCase())
                                                || user.getGender().toLowerCase().contains(search.toLowerCase()))
                                        || user.getDob().toString().toLowerCase().contains(search.toLowerCase())
                                        || user.getNationalId().toLowerCase().contains(search.toLowerCase())))
                        .toList();
                return findUser;
            }
            log.info(findSchool + "");
        } catch (Exception e) {
            log.info(e + "");
        }
        return null;
    }
}
