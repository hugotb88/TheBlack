package com.theblack.The.Black.serviceFeign;

import com.theblack.The.Black.model.User;
import com.theblack.The.Black.repositoryFeign.UserRepositoryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Victor Hugo Olvera Cruz
 * Emulates a remote service called in another application by an external rEST
 */
@Service
public class UserServiceFeign {

    @Autowired
    UserRepositoryFeign userRepositoryFeign;


    //Creates a new User
    public User createUser(User user){
        User result = new User(user.getType(),user.getFirstName(),user.getLastName(),user.getAge(),user.getMail(),user.getDateOfBirth());
        return userRepositoryFeign.save(result);
    }

    //Get All the Users
    public ArrayList<User> getAllUsers(){
        ArrayList<User> result = (ArrayList<User>) userRepositoryFeign.findAll();
        return result;
    }

    //Get user by Mail
    public User getUserByMail(String mail){
        User result = userRepositoryFeign.getUserByMail(mail);
        return result;
    }

    //Delete an User by Id
    public void deleteUser(User user){
        userRepositoryFeign.delete(user);
    }

    //Update an User
    public User updateUser(User user){
        User resultUpdateUser = userRepositoryFeign.save(user);
        return resultUpdateUser;
    }
}
