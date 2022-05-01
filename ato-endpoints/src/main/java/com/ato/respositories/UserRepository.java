package com.ato.respositories;

import com.ato.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.escuela.api.db.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT R FROM User R WHERE R.email=?1")
    Optional<User> findUserByEmailID(String email);

    @Query("SELECT R FROM User R WHERE R.appId=?1")
    Optional<User> findUserByAppId(String appId);

    @Query("SELECT R FROM User R WHERE R.email=?1 and R.password=?2")
    Optional<User> userLogin(String email,String password);

}
