package com.test.Controller;

import com.test.DAO.TeacherDAO;
import com.test.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TeacherController {

    @Autowired
    private TeacherDAO teacherDAO;

    @PostMapping(value = "/add")
    public String add(Teacher teacher){
        teacherDAO.add(teacher);
        return "redirect:/getAll";
    }

    @GetMapping(value = "/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("teachers",teacherDAO.getAll());
        return modelAndView;
    }

    @GetMapping(value = "/getById/{id}")
    public ModelAndView getById(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("teacher",teacherDAO.getById(id));
        return modelAndView;
    }

    @PutMapping(value = "/update")
    public String update(Teacher teacher){
        teacherDAO.update(teacher);
        return "redirect:/getAll";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){
        teacherDAO.delete(id);
        return "redirect:/getAll";
    }


}
