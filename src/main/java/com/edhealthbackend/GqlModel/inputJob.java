package com.edhealthbackend.GqlModel;

import java.time.LocalDateTime;

import com.edhealthbackend.Interfaces.graphQlData;
import com.edhealthbackend.Model.Job;
import lombok.Data;
@Data
public class inputJob implements graphQlData<Job>{
private long id;
private String title;
private String description;
private LocalDateTime postDate=LocalDateTime.now();
    @Override
    public Job getData() {
       return new Job(id, title, description, postDate);
    }

}
