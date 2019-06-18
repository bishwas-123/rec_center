package dao;

import model.CheckInUser;
import model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CheckInDAO {
    private static CheckInDAO checkin =null;
    private ArrayList<CheckInUser> users;



    private CheckInDAO() {
        users=new ArrayList<>();
        users.add(new CheckInUser(154, LocalDate.now(), LocalTime.now()));
    }

    public static CheckInDAO getInstance(){
        if(checkin ==null){
           checkin=new CheckInDAO();
        }
        return checkin;
    }
    public void addUser(CheckInUser user){
        users.add(user);
    }
    public void deleteUser(CheckInUser  user){
        users.remove(user);
    }

    public List getUserById(int id){
        List<CheckInUser> data= users.stream().filter(user->user.getUserId()==id).collect(Collectors.toList());
        if(data==null) { return null;}
        return data;
    }
    public List<User> getAllCheckInUsers(){
        List<User> totalUsers=UserDAO.getInstance().getUsers();
        List<User> data=new ArrayList<>();
        for(User user:totalUsers){
            for(CheckInUser inUser:users){
                if(user.getUserId()==inUser.getUserId()){
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
                    LocalTime time = inUser.getCheckInTime();
                    String f = formatter.format(time);
                    user.setCheckInTime(f);

                    data.add(user);
                }
            }
        }
        if(data==null || data.isEmpty()) {
            return  null;
        }
        return data;
    }
    public boolean checkUser(CheckInUser newUser){
        if(users.contains(newUser))
            return true;
        return false;
    }

}
