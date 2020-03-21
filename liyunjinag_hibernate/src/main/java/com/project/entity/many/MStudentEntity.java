package com.project.entity.many;

import com.project.entity.TeacherEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_student")
public class MStudentEntity {
    @Id
    @Column(name = "pk_studentId",length = 32)
    @GenericGenerator(name = "studentuuid",strategy = "uuid")
    @GeneratedValue(generator ="studentuuid")
    private String studentId;
    @Column(name = "f_studentName",length = 48)
    private String studentName;
    @ManyToMany
    @JoinTable(name = "m_s_t",joinColumns = {@JoinColumn(name = "fk_stuID")},
    inverseJoinColumns = {@JoinColumn(name = "fk_teacherID")})
    private Set<MTeacherEntity> teacherSet;

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

    public Set<MTeacherEntity> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<MTeacherEntity> teacherSet) {
        this.teacherSet = teacherSet;
    }
}
