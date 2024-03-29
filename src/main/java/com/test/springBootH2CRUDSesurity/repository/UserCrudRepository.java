package com.test.springBootH2CRUDSesurity.repository;

import com.test.springBootH2CRUDSesurity.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}

