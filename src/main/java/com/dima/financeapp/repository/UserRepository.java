package com.dima.financeapp.repository;

import com.dima.financeapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :email LIMIT 1")
    User getUserByEmail(@Param("email") String email);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
