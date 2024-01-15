package com.edhealthbackend.controller;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.edhealthbackend.GqlModel.UserPage;
import com.edhealthbackend.GqlModel.inputUser;
import com.edhealthbackend.Model.Hospital;
import com.edhealthbackend.Model.School;
import com.edhealthbackend.Model.User;
import com.edhealthbackend.Repository.HospitalRepo;
import com.edhealthbackend.Repository.SchoolRepo;
import com.edhealthbackend.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class UserController {
@Autowired private UserRepo userRepo;
@Autowired SchoolRepo schoolRepo;
@Autowired HospitalRepo hospitalRepo;
@MutationMapping()
public User saveUser(@Argument(name = "input")inputUser data){
    School school=schoolRepo.findById(data.getSchoolId()).orElse(null);
    return userRepo.save(new User(data.getId(), data.getName(), data.getGender(), data.getNationalId(), data.getProfilePicture(), data.getPhoneNumber(), data.getEmail(), data.getDob(), data.getRole(), BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()),school));
}
@MutationMapping()
public String deleteUser(@Argument()long id){
    try {
        User User=userRepo.findById(id).orElse(null);
      if(User!=null) {
        userRepo.deleteById(id); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@MutationMapping()
public String addUserRole(@Argument(name = "userEmail")String userEmail,@Argument(name = "role")String role,@Argument(name = "domainName")String domainName,@Argument(name = "domainId")long domainId){
User user=userRepo.findByEmail(userEmail);
if(user!=null)
if(domainName.equals("school")){
School school=schoolRepo.findById(domainId).orElse(null);
user.setRole("ROLE_SCHOOL");
}else if(domainName.equals("cnm")){
user.setRole("ROLE_CNM");
}else if(domainName.equals("hospital")){
Hospital hospital=hospitalRepo.findById(domainId).orElse(null);
user.setRole("ROLE_HOSPITAL");
}
else if(domainName.equals("student")){
user.setRole("ROLE_STUDENT");
}else{
user.setRole("ROLE_NONE");
}

return null;
}
@QueryMapping()
public User findUserById(@Argument long id){
    try {
         return userRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@QueryMapping()
public List<User> getAllUsers(){
    return userRepo.findAll();
}
@QueryMapping()
public UserPage useListPagination( @Argument(name = "pageNumber") int pageNumber,@Argument(name = "pageSize") int pageSize,@Argument(name = "sortBy") String sortBy){
Pageable page=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).ascending());
Page<User>listOfUser=userRepo.findAll(page);
return new UserPage(listOfUser.getContent(), listOfUser.getNumber(),listOfUser.getTotalPages(),userRepo.findAll().size());
}
@QueryMapping()
public int numberOfUsers(){
    return userRepo.findAll().size();
}
}
