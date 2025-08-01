package com.satyanand.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee1 {

    @Id
    private Integer eid;

    private String eName;

    @Transient
    private String eCity;

    private Integer age;

    public Employee1() {
        System.out.println("No param constructor");
    }


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteCity() {
        return eCity;
    }

    public void seteCity(String eCity) {
        this.eCity = eCity;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "eid=" + eid +
                ", eName='" + eName + '\'' +
                ", eCity='" + eCity + '\'' +
                ", age=" + age +
                '}';
    }
}
