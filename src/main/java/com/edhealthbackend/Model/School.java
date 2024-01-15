package com.edhealthbackend.Model;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String name;
@Column(columnDefinition="longBlob")
private String logo;
@ManyToOne()
private Location location;
private LocalDateTime createdOn;
public School(long id, String name,String logo,LocalDateTime createdOn,Location location){
    this.id=id;
    this.name=name;
    this.logo=logo;
    this.createdOn=LocalDateTime.now();
    this.location=location;
}
}
