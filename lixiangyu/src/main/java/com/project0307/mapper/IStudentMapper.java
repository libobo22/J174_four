package com.project0307.mapper;

import com.project0307.entity.StudentEntity;
import org.apache.ibatis.annotations.*;

/**
 * 学生mapper接口
 */
public interface IStudentMapper {
    @Insert("insert into t_student(f_name,f_phone) values(#{name},#{phone})")
    public void add(StudentEntity student);

    @Delete("delete from t_student where pk_id=#{id}")
    public void del(int id);

    @Update("update t_student set f_phone=#{param2} where pk_id=#{param1}")
    public void update(int id, String phone);

    @Select("select * from t_student where pk_id=#{id}")
    @ResultMap("studentMap")
    public StudentEntity findById(int id);
}
