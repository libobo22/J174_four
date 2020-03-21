package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="sys_teacher")
public class TeacherEntity {
    @Id
    @Column(name="t_id",length=32)
    @GenericGenerator(name="tuuid",strategy = "uuid")
    @GeneratedValue(generator = "tuuid")
    private String teacherId;
    @Column(name="t_name",length = 48)
    private  String teacherName;
    @Column(name="t_class",length = 48)
    private String teacherClass;

    @OneToMany (mappedBy="teacher")
    private Set<StudentEntity> setStus;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }
}
