package com.edhealthbackend.GqlModel.Paginations;
import java.util.List;
import com.edhealthbackend.GqlModel.Pagination;
import com.edhealthbackend.Model.School;
public class SchoolPage extends Pagination<School>{

    public SchoolPage(List<School> content, int pageNumber, int pageSize, int size) {
        super(content, pageNumber, pageSize, size);
    }

}
