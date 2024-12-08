package org.zorba.entity;

import java.util.Set;

public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String teacherSpecialization;
    private String teacherEmail;
    private Long teacherMobile;
    private String teacherAddress;
    private Set<Student> students;
    private Set<Department> department;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSpecialization() {
        return teacherSpecialization;
    }

    public void setTeacherSpecialization(String teacherSpecialization) {
        this.teacherSpecialization = teacherSpecialization;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public Long getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(Long teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
