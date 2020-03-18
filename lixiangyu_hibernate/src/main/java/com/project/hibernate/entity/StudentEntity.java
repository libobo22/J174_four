package com.project.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_student")
public class StudentEntity {
    @Id
    @Column(name = "s_id", length = 32)
    @GenericGenerator(name = "suuid", strategy = "uuid")
    @GeneratedValue(generator = "suuid")
    private String studentId;
    @Column(name = "s_name", length = 48)
    private String studentName;
    //多对一默认急加载
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "f_t_id")
    private TeacherEntity teacher;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }
}
