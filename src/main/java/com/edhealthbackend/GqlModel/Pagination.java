package com.edhealthbackend.GqlModel;
import java.util.List;
import lombok.*;
@Data
@AllArgsConstructor
public class Pagination<T> {
private List<T> content;
private  int pageNumber;
private int  pageSize;
private int size;
}
