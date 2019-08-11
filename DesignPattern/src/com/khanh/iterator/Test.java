package com.khanh.iterator;

public class Test {
    public static void main(String[] args) {
 
    	
        Class myClass = new Class();
        
        myClass.addSubject(new Subject("Math", "Teacher 1"));
        myClass.addSubject(new Subject("literature", "Teacher 2"));
        myClass.addSubject(new Subject("Geography", "Teacher 3"));
 
        Iterator<Subject> iterator = myClass.iterator();
        while (iterator.hasNext()) {
            Subject item = iterator.next();
            System.out.println(item);
        }
    }
}
