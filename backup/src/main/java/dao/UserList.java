package dao;
import model.Admin;

import java.util.ArrayList;
import java.util.List;
public class UserList {
    private ArrayList<Admin> usernames=new ArrayList<>();
    {
        addUsers(new Admin("ram@gmail.com","12345"));
        addUsers(new Admin("hari@gmail.com","12344"));
        addUsers(new Admin("bishwas@gmail.com","bishwas"));

    }
    public void addUsers(Admin user){
        usernames.add(user);
    }
    public ArrayList<Admin> getUsernames(){
        return usernames;
    }

    public List<Admin> getAllUsers(){
        return new ArrayList<>(usernames);
    }
}
