package dao;

import model.Check;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class CheckinDAO {
    private Map<User, Check> checkinMap;
    private static CheckinDAO checkinDAO =null;

    private CheckinDAO(){
        checkinMap=new HashMap<>();
    }

    public static CheckinDAO getInstance(){
        if(checkinDAO ==null){
            checkinDAO =new CheckinDAO();
        }
        return checkinDAO;
    }

    public Map<User, Check> getCheckinMap() {
        return checkinMap;
    }

    public void setCheckinMap(Map<User, Check> checkinMap) {
        this.checkinMap = checkinMap;
    }
}
