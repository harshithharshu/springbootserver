package cow_bull_app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public GetAllUsersResponse getAllUsers() {
        List<User> users = new ArrayList<User>();
        for(User us: userRepository.findAll()){
            users.add(us);
        }
        GetAllUsersResponse getAllUsersResponse = new GetAllUsersResponse(users);
        return getAllUsersResponse;
    }

    public UserSignupResponse addUser(User user) {
        UserSignupResponse userSignupResponse = new UserSignupResponse(UserSignupResponse.Status.SUCCESS);
        if(user.name == null) userSignupResponse.setStatus(UserSignupResponse.Status.INVALID_NAME);
        else if(getUser(user.userId) != null) userSignupResponse.setStatus(UserSignupResponse.Status.USER_EXISTS);
        else
            userRepository.save(user);
        return userSignupResponse;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.delete(userId);
    }

    public User getUser(String userId) {
        return userRepository.findOne(userId);
    }
}
