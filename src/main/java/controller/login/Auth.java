package controller.login;


import model.Admin;
import dao.UserList;

public class Auth {
    public static boolean authenticate(String userName, String password) {
       // Admin userData=new Admin("bishwas","bishwas1");
        UserList userList=new UserList();
       // userList.addUsers(userData);
        for(Admin u:userList.getUsernames()){
             if(u.getUsername().equals(userName)&& u.getPassword().equals(password)){
                 return  true;
             }
        }
        return false;
    }
}
