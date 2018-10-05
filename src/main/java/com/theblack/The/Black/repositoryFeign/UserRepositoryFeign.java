package com.theblack.The.Black.repositoryFeign;

import com.theblack.The.Black.model.User;
import feign.Param;
import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Victor Hugo Olvera Cruz
 * This emulates a repository located in another application, called by a @Service,
 * @Service was called by another REST
 */
@Repository
public interface UserRepositoryFeign extends JpaRepository<User, Serializable>  {


    //Get an User by mail
    @Query(value="SELECT * FROM users u WHERE u.mail = :mail",nativeQuery=true)
    public User getUserByMail(@Param("mail") String mail);

}
