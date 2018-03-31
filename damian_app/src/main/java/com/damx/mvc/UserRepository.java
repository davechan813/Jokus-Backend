/****************************************************
 author: Guo Jiayu, potplus@live.com, http://gjyu.me
 the damianX back-end software is a private property
 Copyright 2018 Guo Jiayu
 *****************************************************/
package com.damx.mvc;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{

    List<User> findByLastName (String lastName);
    List<User> findByEmail (String email);
    User findById(Integer id);
    User findByToken(String token);
}
