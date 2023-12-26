package com.edhealthbackend.GqlModel;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.Training;

public class inputTraining extends Training implements graphQlData<Training> {

    @Override
    public Training getData() {
       return new Training(getId(), getTitle(), getDescription(), getPostDate(), getDeadline());
    }

}
