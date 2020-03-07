package com.project.service;

import com.project.entity.StudentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudentService {


    public void add(StudentEntity student);


    public void del(int id);


    public void updatePhone(int id, String phone);


    public StudentEntity findById(int id);
}
