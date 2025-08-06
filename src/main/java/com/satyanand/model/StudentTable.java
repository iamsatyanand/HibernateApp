package com.satyanand.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class StudentTable {

    @Id
    private Integer id;

    private String name;

    private String city;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course_mapping",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name="coourse_id")
    )
    private Set<CourseTable> courses;

    public Set<CourseTable> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseTable> courses) {
        this.courses = courses;
    }

    public StudentTable() {
    }


    @Override
    public String toString() {
        return "StudentTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", courses=" + courses +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
