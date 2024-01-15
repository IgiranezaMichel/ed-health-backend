package com.edhealthbackend.Model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String title;
private String description;
private LocalDateTime postDate=LocalDateTime.now();
private LocalDateTime deadline;
private String trainers;
private boolean isApprovedByCnm;
private boolean isDeniedByCnm;
private LocalDateTime approvedDate;
@ManyToOne
private Hospital hospital;
}