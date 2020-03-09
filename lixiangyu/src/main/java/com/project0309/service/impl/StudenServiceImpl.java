package com.project0309.service.impl;

import com.project0309.entity.StudentEntity;
import com.project0309.mapper.IStudentMapper;
import com.project0309.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 学生业务接口实现类
 */
@Service
@Transactional
public class StudenServiceImpl implements IStudentService {
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
    public void update(int id, String phone) {
        mapper.update(id, phone);
    }

    @Override
    public StudentEntity findById(int id) {
        return mapper.findById(id);
    }
}
