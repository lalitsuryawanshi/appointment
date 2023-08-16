package com.x3t.lalit.appointment.utils;

import java.util.HashSet;

public class EngineerSet<T> {

    private final HashSet<T> set;
    private final int maxCapacity = 2;

    public EngineerSet() {
        set = new HashSet<>();
    }

    public boolean add(T element) {
        if (set.size() < maxCapacity) {
            return set.add(element);
        }
        return false;
    }

    public boolean contains(T element) {
        return set.contains(element);
    }

    public boolean remove(T element) {
        return set.remove(element);
    }

    public int size() {
        return set.size();
    }

    public void clear() {
        set.clear();
    }

    public void printAllElements() {
        for (T t : set) {
            System.out.println(t);
        }
    }

}
