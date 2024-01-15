package com.edhealthbackend.Model;
import java.time.LocalDateTime;
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
private String nationalId;
@Column(columnDefinition="longBlob")
private String profilePicture;
private String phoneNumber;
private String email;
private LocalDateTime dob;
private String role;
private String password;
}
