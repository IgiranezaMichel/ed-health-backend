package com.edhealthbackend.GqlModel;
import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.Hospital;

import lombok.Data;

@Data
public class inputHospital implements graphQlData<Hospital>{
private long id;
private String name;
@Override
public Hospital getData() {
 return new Hospital(id, name);
}
}
