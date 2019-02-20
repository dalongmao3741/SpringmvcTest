package com.test.DAO;

import com.test.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherDAO {
    private Map<Integer, Teacher> map = new HashMap<>();
    public void add(Teacher teacher){
        map.put(teacher.getId(),teacher);
    }
    public Collection<Teacher> getAll(){
        return map.values();
    }
    public Teacher getById(int id){
        return map.get(id);
    }
    public void update(Teacher teacher){
        map.put(teacher.getId(),teacher);
    }
    public void delete(int id){
        map.remove(id);
    }

}
