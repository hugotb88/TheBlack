package com.theblack.The.Black.serviceFeign;

import com.theblack.The.Black.model.User;
import com.theblack.The.Black.model.UserId;
import com.theblack.The.Black.repositoryFeign.UserRepositoryFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Victor Hugo Olvera Cruz
 * Emulates a remote service called in another application by an external rEST
 */
@Service
public class UserServiceFeign {

    //Logger
    Logger logger = LoggerFactory.getLogger(UserServiceFeign.class);

    @Autowired
    UserRepositoryFeign userRepositoryFeign;


    //Creates a new User
    public User createUser(User user){
        logger.info("UserServiceFeign, creation of new user:" + user.getMail());
        User result = new User(user.getType(),user.getFirstName(),user.getLastName(),user.getAge(),user.getMail(),user.getDateOfBirth());
        return userRepositoryFeign.save(result);
    }

    //Get All the Users
    public ArrayList<User> getAllUsers(){
        logger.info("UserServiceFeign, getAllUsers()...");
        ArrayList<User> result = (ArrayList<User>) userRepositoryFeign.findAll();
        return result;
    }

    //Get user by Mail
    public User getUserByMail(String mail){
        logger.info("UserServiceFeign, getUserByMail()...");
        User result = userRepositoryFeign.getUserByMail(mail);
        return result;
    }

    //Delete an User by Id
    @Transactional
    public Integer deleteUser(Long idUser){
        logger.info("UserServiceFeign, deleteUser()...");
        Integer result = 0;
        result = userRepositoryFeign.deleteUserById(idUser);
        return result;
    }

    //Update an User
    public User updateUser(User user){
        logger.info("UserServiceFeign, updateUser()...");
        UserId id = new UserId(); //Creation of id for JPA
        id.setIdUser(user.getIdUser());
        id.setMail(user.getMail());
        Optional<User> userfromDB = userRepositoryFeign.findById(id);
        User userToUpdate = userfromDB.get();
        userToUpdate.setAge(user.getAge());
        userToUpdate.setDateOfBirth(user.getDateOfBirth());
        userToUpdate.setDateOfUpdate(LocalDateTime.now());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setType(user.getType());
        userToUpdate.setMail(user.getMail());
        return userRepositoryFeign.save(userToUpdate);
    }
}
