package com.edhealthbackend.GqlModel.Paginations;

import java.util.List;

import com.edhealthbackend.GqlModel.Pagination;
import com.edhealthbackend.Model.Hospital;

public class HospitalPage extends Pagination<Hospital>{
    public HospitalPage(List<Hospital> content, int pageNumber, int pageSize, int size) {
        super(content, pageNumber, pageSize, size);
    }


}
