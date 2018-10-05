package com.theblack.The.Black.service;

import com.theblack.The.Black.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.PathParam;
import java.util.ArrayList;

/**
 * @author Victor Hugo Olvera Cruz
 * This service calls a Feign Client
 */
@FeignClient(name = "userService", url="${feign.user}")
public interface UserService {

    //Create new UserService
    @RequestMapping(value="/feign/user", method = RequestMethod.POST)
    public User createUser();

    //Get All the Users
    @RequestMapping(value="/feign/user", method = RequestMethod.GET)
    public ArrayList<User> getAllUsers();

    //Get an user by Mail
    @RequestMapping(value="/feign/user/{mail}", method = RequestMethod.GET)
    public User getUserByMail(@PathVariable(value="mail") String mail);

    //Delete an User
    @RequestMapping(value = "/feign/user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user);

    //Update an UserService
    @RequestMapping(value = "/feign/user/{user}", method = RequestMethod.PUT)
    public User updateUser (@PathVariable(value="user") com.theblack.The.Black.model.User user);

}
