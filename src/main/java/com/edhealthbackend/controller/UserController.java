package com.edhealthbackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.edhealthbackend.GqlModel.inputUser;
import com.edhealthbackend.Model.User;
import com.edhealthbackend.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class UserController {
@Autowired private UserRepo ac_ResultRepo;
@MutationMapping()
public User saveUser(@Argument(name = "input")inputUser data){
    return ac_ResultRepo.save(data.getData());
}
@MutationMapping()
public String deleteUser(@Argument()long id){
    try {
        User User=ac_ResultRepo.findById(id).orElse(null);
      if(User!=null) {
        ac_ResultRepo.deleteById(id); 
        return "Accademic Deleted Sucessfully";
    } 
    else return "Please Select Academic record";
    } catch (Exception e) {
        return "Error haappen";
    }
}
@QueryMapping()
public User findUserById(@Argument long id){
    try {
         return ac_ResultRepo.findById(id).orElse(null);
    } catch (Exception e) {
        log.info(e.getMessage());
        return null;
    }
   
}
@QueryMapping()
public List<User> getAllUsers(){
    return ac_ResultRepo.findAll();
}
}
