package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class UserDAO {
    private ArrayList<User> users;
    private static UserDAO userDAO =null;
    private UserDAO() {
        users=new ArrayList<>();
        users.add(new User(123,"test","test", "testName","testOccupation",
                "testAddress","3216549870","test@test.com", "2009-12-30","Other"));
        users.add(new User(124,"admin","admin", "adminName","adminOccupation",
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
//    public void setUsers(ArrayList<Admin> users) {
//        this.users = users;
//    }

    public void addUser(User user){
        users.add(user);
    }

    public List getUserById(Integer id){
        List<User> data= users.stream().filter(user -> user.getUserId()==id).collect(Collectors.toList());

        if(data==null){
             return null;
        }
        return data;
    }


    public boolean checkUser(User newUser){
        if(users.contains(newUser))
            return true;
        return false;
    }


}
