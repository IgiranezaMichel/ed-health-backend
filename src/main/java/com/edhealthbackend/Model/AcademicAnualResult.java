package com.edhealthbackend.Model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicAnualResult {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private double anualReportMarks;
private double anualDisciplineMarks;
}