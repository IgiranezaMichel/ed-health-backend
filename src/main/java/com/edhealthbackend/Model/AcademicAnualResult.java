package com.edhealthbackend.Model;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicAnualResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private BigDecimal anualReportMarks;
    private BigDecimal anualDisciplineMarks;
    private int academicYear;
}