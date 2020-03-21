package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_teacher")
public class TeacherEntity {
    @Id
    @GenericGenerator(name = "teacheruuid",strategy = "uuid")
    @GeneratedValue(generator ="teacheruuid")
    @Column(length = 32,name = "pk_teacherId")
    private String teacherId;
    @Column(length = 48,name = "f_teacherName")
    private String teacherName;
    @Column(length = 48,name = "f_teacherClass")
    private String teacherClass;
    //mappedBy把映射权交给多的一方
    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private Set<StudentEntity> studentSet;

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

    public Set<StudentEntity> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<StudentEntity> studentSet) {
        this.studentSet = studentSet;
    }
}
