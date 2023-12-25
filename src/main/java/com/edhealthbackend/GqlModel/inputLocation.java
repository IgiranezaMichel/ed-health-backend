package com.edhealthbackend.GqlModel;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.Location;

public class inputLocation extends Location implements graphQlData<Location>{

    @Override
    public Location getData() {
     return new Location(getId(), getName(), getType());
    }

}
