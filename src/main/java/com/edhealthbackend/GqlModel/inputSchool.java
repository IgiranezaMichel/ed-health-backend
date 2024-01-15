package com.edhealthbackend.GqlModel;

import com.edhealthbackend.Model.School;

import lombok.Getter;
import lombok.Setter;
public class inputSchool extends School{
    @Getter @Setter
    private long locationId;
}
