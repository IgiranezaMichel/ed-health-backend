package com.edhealthbackend.GqlModel;
import com.edhealthbackend.Model.Location;

import lombok.Getter;
import lombok.Setter;

public class inputLocation extends Location{
    @Getter @Setter
    private long locationId;
}
