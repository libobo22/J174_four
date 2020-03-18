package com.project.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_student")
public class StudentEntity {
    @Id
    @Column(name = "pk_studentId",length = 32)
    @GenericGenerator(name = "studentuuid",strategy = "uuid")
    @GeneratedValue(generator ="studentuuid")
    private String studentId;
    @Column(name = "f_studentName",length = 48)
    private String studentName;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="fk_teacherId")
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
