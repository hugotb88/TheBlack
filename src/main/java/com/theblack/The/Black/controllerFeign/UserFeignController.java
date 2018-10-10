package com.theblack.The.Black.controllerFeign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theblack.The.Black.model.User;
import com.theblack.The.Black.serviceFeign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Victor Hugo Olvera Cruz
 *
 */
@Controller
public class UserFeignController {

    @Autowired
    UserServiceFeign userServiceFeign;

    //Create new UserService
    @RequestMapping(
            value="/feign/user",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User createUser(@RequestBody User user) throws Exception {
        User result = userServiceFeign.createUser(user);
        return result;
    }

    //Get All the Users
    @RequestMapping(
            value="/feign/user",
            method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<User> getAllUsers(){
        return userServiceFeign.getAllUsers();
    }

    //Get an user by Mail
    @RequestMapping(
            value="/feign/user/{mail}",
            method = RequestMethod.GET)
    @ResponseBody
    public User getUserByMail(@PathVariable(value="mail") String mail){
        return userServiceFeign.getUserByMail(mail);
    }

    //Delete an User
    @RequestMapping(
            value = "/feign/user/{idUser}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable Long idUser){
        if(userServiceFeign.deleteUser(idUser) == 0){
            return "Error";
        }else{
            return "Ok";
        }
    }

    //Update an User
    @RequestMapping(
            value = "/feign/user",
            method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser (@RequestBody User user){
        return userServiceFeign.updateUser(user);
    }
}
