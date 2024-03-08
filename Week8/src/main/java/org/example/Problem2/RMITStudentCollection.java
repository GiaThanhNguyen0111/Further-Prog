package org.example.Problem2;

import java.util.Iterator;
import java.util.List;

public class RMITStudentCollection {
    static List<RMITStudent> studentList;

    static class RMITIterator implements Iterator<RMITStudent> {

        public int count;

        public RMITIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            while(count < studentList.size()) {
                if (studentList.get(count).isShared()) {
                    return true;
                }
                count++;
            }
            return false;
        }

        @Override
        public RMITStudent next() {
            while(count < studentList.size()) {
                if (studentList.get(count).isShared()) {
                    return studentList.get(count);
                }
                count++;
            }
            return null;
        }
    }

    private Iterator<RMITStudent> iterator() {
        return new RMITIterator();
    }
}
