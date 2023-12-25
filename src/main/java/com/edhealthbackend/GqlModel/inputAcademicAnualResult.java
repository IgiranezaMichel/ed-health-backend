package com.edhealthbackend.GqlModel;

import java.math.BigDecimal;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.AcademicAnualResult;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class inputAcademicAnualResult implements graphQlData<AcademicAnualResult>{
private long id;
private BigDecimal anualReportMarks;
private BigDecimal anualDisciplineMarks;
private int academicYear;
@Override
public AcademicAnualResult getData() {
  return new AcademicAnualResult(id, anualReportMarks, anualDisciplineMarks, academicYear);
}
}
