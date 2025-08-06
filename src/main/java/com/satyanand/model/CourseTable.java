package com.satyanand.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class CourseTable {

    @Id
    private Integer id;

    private String courseName;

    private String coursePrice;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentTable> students;

    public CourseTable() {
    }

    public Set<StudentTable> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentTable> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", coursePrice='" + coursePrice + '\'' +
//                ", students=" + students +
                '}';
    }
}
