package com.project.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_teacher")
public class MTeacherEntity {
    @Id
    @GenericGenerator(name = "teacheruuid",strategy = "uuid")
    @GeneratedValue(generator ="teacheruuid")
    @Column(length = 32,name = "pk_teacherId")
    private String teacherId;
    @Column(length = 48,name = "f_teacherName")
    private String teacherName;
    @ManyToMany(mappedBy = "teacherSet")
    private Set<MStudentEntity> studentSet;

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

    public Set<MStudentEntity> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<MStudentEntity> studentSet) {
        this.studentSet = studentSet;
    }
}
