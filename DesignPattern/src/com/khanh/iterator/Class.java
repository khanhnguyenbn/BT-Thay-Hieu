package com.khanh.iterator;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private List<Subject> subjects = new ArrayList<>();
 
    public void addItem(Subject item) {
        subjects.add(item);
    }
 
    public Iterator<Subject> iterator() {
        return new ClassIterator();
    }
 
    class ClassIterator implements Iterator<Subject> {
        private int currentIndex = 0;
 
        @Override
        public boolean hasNext() {
            return currentIndex < subjects.size();
        }
 
        @Override
        public Subject next() {
            return subjects.get(currentIndex++);
        }
    }
}
