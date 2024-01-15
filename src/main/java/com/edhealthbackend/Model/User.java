package com.edhealthbackend.Model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Gender is required")
    private String gender;
    @Column(unique = true)
    private String nationalId;
    @Column(columnDefinition = "longBlob")
    private String profilePicture;
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Date of Birth is required")
    @Past(message = "Please your date of birth has to be under present date")
    private LocalDateTime dob;
    private String role;
    private String password;
    @ManyToOne
    private School school;
}
