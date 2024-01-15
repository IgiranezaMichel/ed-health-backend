package com.edhealthbackend.Model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "location")
    private List<Location> locationList;

    public Location(long id, String name, String type, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    @OneToMany(mappedBy = "location")
    private List<School> listOfSchool;
    @OneToMany(mappedBy = "location")
    private List<Hospital> listOfHospital;
}
