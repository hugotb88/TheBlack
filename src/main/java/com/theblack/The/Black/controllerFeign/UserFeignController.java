package com.theblack.The.Black.controllerFeign;

import com.theblack.The.Black.model.User;
import com.theblack.The.Black.serviceFeign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value="/feign/user", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user){
        return userServiceFeign.createUser(user);
    }

    //Get All the Users
    @RequestMapping(value="/feign/user", method = RequestMethod.GET)
    public ArrayList<User> getAllUsers(){
        return userServiceFeign.getAllUsers();
    }

    //Get an user by Mail
    @RequestMapping(value="/feign/user/{mail}", method = RequestMethod.GET)
    public User getUserByMail(@PathVariable(value="mail") String mail){
        return userServiceFeign.getUserByMail(mail);
    }

    //Delete an User
    @RequestMapping(value = "/feign/user", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@RequestBody User user){
        userServiceFeign.deleteUser(user);
    }

    //Update an User
    @RequestMapping(value = "/feign/user", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser (@RequestBody User user){
        return userServiceFeign.updateUser(user);
    }
}
