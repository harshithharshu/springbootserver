package cow_bull_app.User;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String userId;
    String name;
    int trophies;

    public User(){

    }

    public User(String userId, String name, int trophies) {
        this.userId = userId;
        this.name = name;
        this.trophies = trophies;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
}
