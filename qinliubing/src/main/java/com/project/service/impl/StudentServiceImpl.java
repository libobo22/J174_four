package com.project.service.impl;

import com.project.entity.StudentEntity;
import com.project.mapper.IStudentMapper;
import com.project.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
    @Resource
    private IStudentMapper mapper;


    @Override
    public void add(StudentEntity student) {
mapper.add(student);
    }

    @Override
    public void del(int id) {
        mapper.del(id);
    }

    @Override
    public void updatePhone(int id, String phone) {
mapper.updatePhone(id, phone);
    }

    @Override
    public StudentEntity findById(int id) {
        return mapper.findById(id);
    }


}
