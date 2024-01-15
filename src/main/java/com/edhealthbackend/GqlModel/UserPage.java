package com.edhealthbackend.GqlModel;

import java.util.List;
import com.edhealthbackend.Model.User;
public class UserPage extends Pagination<User>{

    public UserPage(List<User> content, int pageNumber, int pageSize, int size) {
        super(content, pageNumber, pageSize, size);
    }
}
