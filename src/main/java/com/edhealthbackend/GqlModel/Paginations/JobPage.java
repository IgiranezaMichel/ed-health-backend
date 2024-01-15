package com.edhealthbackend.GqlModel.Paginations;

import java.util.List;

import com.edhealthbackend.GqlModel.Pagination;
import com.edhealthbackend.Model.Job;

public class JobPage extends Pagination<Job>{

    public JobPage(List<Job> content, int pageNumber, int pageSize, int size) {
        super(content, pageNumber, pageSize, size);
    }
}
