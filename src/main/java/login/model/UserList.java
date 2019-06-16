package login.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private ArrayList<User> usernames=new ArrayList<>();
    {
        addUsers(new User("ram@gmail.com","12345"));
        addUsers(new User("hari@gmail.com","12344"));

    }



    public void addUsers(User user){
        usernames.add(user);
    }
    public ArrayList<User> getUsernames(){
        return usernames;
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(usernames);
    }
}
