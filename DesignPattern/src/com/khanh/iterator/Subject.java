package com.khanh.iterator;

public class Subject {
    private String name;
    private String teacher;
 
    public Subject(String name, String teacher) {
        super();
        this.name = name;
        this.teacher = teacher;
    }
 
    @Override
    public String toString() {
        return "name: " + name + ", " + "teacher: " + teacher;
    }
}
