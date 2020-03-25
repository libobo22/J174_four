package com.project.hibernate.entity.many;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "m_student")
public class MStudentEntity {
    @Id
    @Column(name = "s_id", length = 32)
    @GenericGenerator(name = "smuuid", strategy = "uuid")
    @GeneratedValue(generator = "smuuid")
    private String studentId;
    @Column(name = "s_name", length = 48)
    private String studentName;
    @ManyToMany(mappedBy = "msSet")
    private Set<MTeacherEntity> mtSet;

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

    public Set<MTeacherEntity> getMtSet() {
        return mtSet;
    }

    public void setMtSet(Set<MTeacherEntity> mtSet) {
        this.mtSet = mtSet;
    }
}
