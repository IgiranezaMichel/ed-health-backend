package com.edhealthbackend.Model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
private String gender;
private String profilePicture;
private String phoneNumber;
private String email;
private Date dob;
private String role;
private String password;
}
