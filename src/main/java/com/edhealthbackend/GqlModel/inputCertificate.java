package com.edhealthbackend.GqlModel;

import java.time.LocalDateTime;

import com.edhealthbackend.Model.Certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class inputCertificate {
private long id;
private LocalDateTime  receivedDate;
private LocalDateTime   expirationDate=LocalDateTime.now();
public Certificate getData(){
 return new Certificate(id, receivedDate, expirationDate);
}
}
