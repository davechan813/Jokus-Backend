package com.damx.mvc;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ParkRepository extends CrudRepository<Park, Long> {
    List<Park> findByName(String name);
    List<Park> findById(Integer id);
}
