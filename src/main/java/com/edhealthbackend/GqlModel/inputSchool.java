package com.edhealthbackend.GqlModel;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.School;

public class inputSchool extends School implements graphQlData<School>{

    @Override
    public School getData() {
        return new School(getId(), getName());
    }

}
