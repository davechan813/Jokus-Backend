/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.mvc;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ParkRepository extends CrudRepository<Park, Long> {
    List<Park> findByName(String name);
    List<Park> findById(Integer id);
}
