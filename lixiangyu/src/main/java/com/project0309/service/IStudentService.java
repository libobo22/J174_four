package com.project0309.service;

import com.project0309.entity.StudentEntity;


/**
 * 学生业务接口
 */
public interface IStudentService {
    public void add(StudentEntity student);

    public void del(int id);

    public void update(int id, String phone);

    public StudentEntity findById(int id);
}
