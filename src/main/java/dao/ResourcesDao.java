package dao;
import model.RecResouces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResourcesDao {
    private static ResourcesDao single = new ResourcesDao();
    public static ResourcesDao getInstance(){
        return single;
    }

    Map<Integer, RecResouces> recResoucesMap = new ConcurrentHashMap<>();{
        recResoucesMap.put(1, new RecResouces(1,"FEATURED SERVICES","Developing Professional Staff",123,"Working TOGETHER to better serve children and youth when"));
        recResoucesMap.put(2, new RecResouces(2,"FEATURED SERVICES","Developing Professional Staff",123,"Working TOGETHER to better serve children and youth when"));
        recResoucesMap.put(3, new RecResouces(3, "FEATURED SERVICES","Developing Professional Staff",123,"Working TOGETHER to better serve children and youth when"));

    }
    public void addResouce(RecResouces recResouces){
        recResoucesMap.put(recResouces.getId(),recResouces);
    }

    public void deleteResoucres(Integer id){
        recResoucesMap.remove(id);


    }

    public void updateResouces(RecResouces recResouces){
        recResoucesMap.put(recResouces.getId(), recResouces);
    }

    public List<RecResouces> getAllResouces(){
        return new ArrayList<>(recResoucesMap.values());
    }

    public RecResouces getResourceById(int id){
        return recResoucesMap.get(id);
    }

    public int genIdDao() {
        return recResoucesMap.keySet().stream().max(Integer::compareTo).get()+1;
    }
}
