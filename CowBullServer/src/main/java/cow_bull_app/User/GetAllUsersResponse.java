package cow_bull_app.User;

import java.util.List;

public class GetAllUsersResponse {
    List<User> userList;

    public GetAllUsersResponse(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
