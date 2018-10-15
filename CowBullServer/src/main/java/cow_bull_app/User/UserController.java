package cow_bull_app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import sun.security.ssl.Debug;

//import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAllUsers")
    public GetAllUsersResponse getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public UserSignupResponse addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser/{userId}")
    public User getUser(@PathVariable String userId){
        return userService.getUser(userId);
    }
}
