package com.edhealthbackend.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.edhealthbackend.Model.Location;

public interface LocationRepo extends JpaRepository<Location,Long>{
    List<Location> findAllByType(String type);

}
