package dao;

import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserDAO {
    private ArrayList<User> users;
    private static UserDAO userDAO =null;

    private UserDAO() {
        users=new ArrayList<>();
        users.add(new User("test","test", "testName","testOccupation",
                "testAddress","3216549870","test@test.com", "2009-12-30","Other"));
        users.add(new User("admin","admin", "adminName","adminOccupation",
                "adminAddress","2165498703","admin@test.com", "2009-12-30","Other"));
    }

    public static UserDAO getInstance(){
        if(userDAO ==null){
            userDAO =new UserDAO();
        }
        return userDAO;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
//
//    public void setUsers(ArrayList<User> users) {
//        this.users = users;
//    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUserById(Integer id){
        return users.stream().filter(user -> user.getUserId()==id).collect(Collectors.toList()).get(0);
    }


    public boolean checkUser(User newUser){
        if(users.contains(newUser))
            return true;
        return false;

//        if(users.indexOf(newUser)<0)
//            return false;
//        else
//            return true;

//        for(User user: users){
//            if(user.equals(newUser))
//                return true;
//        }
//        return false;
    }


}
