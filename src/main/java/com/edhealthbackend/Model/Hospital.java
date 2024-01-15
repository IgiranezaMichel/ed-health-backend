package com.edhealthbackend.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(columnDefinition = "longBlob")
    private String logo;
    private LocalDateTime createdOn = LocalDateTime.now();
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "hospital")
    private List<Training> trainingList;

    public Hospital(long id, String name, String logo, LocalDateTime createdOn, Location location) {
        this(id, name, logo, createdOn, location, null);
    }
}