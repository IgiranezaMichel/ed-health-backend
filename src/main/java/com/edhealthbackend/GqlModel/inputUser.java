package com.edhealthbackend.GqlModel;

import org.mindrot.jbcrypt.BCrypt;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.User;

public class inputUser extends User implements  graphQlData<User>{
    @Override
    public User getData() {
       return new User(getId(), getName(), getGender(), getProfilePicture(), getPhoneNumber(), getEmail(), getDob(), getRole(),BCrypt.hashpw(getPassword(),BCrypt.gensalt()));
    }

}
