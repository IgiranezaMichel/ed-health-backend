package com.edhealthbackend.GqlModel.Paginations;

import java.util.List;

import com.edhealthbackend.GqlModel.Pagination;
import com.edhealthbackend.Model.Training;

public class TrainingPage extends Pagination<Training>{
    public TrainingPage(List<Training> content, int pageNumber, int pageSize, int size) {
        super(content, pageNumber, pageSize, size);
    }

}
