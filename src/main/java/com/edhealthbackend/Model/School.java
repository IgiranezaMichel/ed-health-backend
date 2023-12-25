package com.edhealthbackend.Model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
}
