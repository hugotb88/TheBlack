package com.theblack.The.Black.repositoryFeign;

import com.theblack.The.Black.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.ResultSet;

/**
 * @author Victor Hugo Olvera Cruz
 * This emulates a repository located in another application, called by a @Service,
 * @Service was called by another REST
 */
@Repository
public interface UserRepositoryFeign extends JpaRepository<User, Serializable>  {


    //Get an User by mail
    @Query(value="SELECT * FROM users u WHERE u.mail =:mail",nativeQuery=true)
    public User getUserByMail(@Param("mail") String mail);

    //Delete an User by id
    @Modifying
    @Query(value="DELETE FROM users WHERE idUser =:idUser",nativeQuery=true)
    public Integer deleteUserById(@Param("idUser") Long idUser);

}
