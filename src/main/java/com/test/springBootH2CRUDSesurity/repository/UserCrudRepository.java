package com.test.springBootH2CRUDSesurity.repository;

import com.test.springBootH2CRUDSesurity.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Long> {
    User findByUsername (String username);
}

