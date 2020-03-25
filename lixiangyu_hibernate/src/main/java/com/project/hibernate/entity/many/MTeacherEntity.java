package com.project.hibernate.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_teacher")
public class MTeacherEntity {
    @Id
    @Column(name = "t_id", length = 32)
    @GenericGenerator(name = "tmuuid", strategy = "uuid")
    @GeneratedValue(generator = "tmuuid")
    private String teacherId;
    @Column(name = "t_name", length = 48)
    private String teacherName;
    @Column(name = "t_class", length = 48)
    private String teacherClass;
    @ManyToMany
    //注解中间表
    @JoinTable(name = "m_s_t", joinColumns = {@JoinColumn(name = "t_id")}, inverseJoinColumns = {@JoinColumn(name = "s_id")})
    private Set<MStudentEntity> msSet;

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

    public Set<MStudentEntity> getMsSet() {
        return msSet;
    }

    public void setMsSet(Set<MStudentEntity> msSet) {
        this.msSet = msSet;
    }
}
