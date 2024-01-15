package com.edhealthbackend.GqlModel;
import java.time.LocalDateTime;

import com.edhealthbackend.Model.School;
import com.edhealthbackend.Model.User;

import lombok.*;

public class inputUser extends User{
    @Getter @Setter
    private long schoolId;

    public inputUser(long id, String name, String gender, String nationalId, String profilePicture, String phoneNumber,
            String email, LocalDateTime dob, String role, String password, School school, long schoolId) {
        super(id, name, gender, nationalId, profilePicture, phoneNumber, email, dob, role, password, school);
        this.schoolId = schoolId;
    }
}
