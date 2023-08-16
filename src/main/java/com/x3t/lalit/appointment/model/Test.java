package com.x3t.lalit.appointment.model;

import com.x3t.lalit.appointment.utils.EngineerSet;


public class Test {

    public static void main(String[] args) {

        EngineerSet<Integer> engineers = new EngineerSet<>();

        engineers.add(1);
        engineers.add(2);

        System.out.println("Size:" +engineers.size());

        engineers.printAllElements();

        engineers.add(10);

        System.out.println("After Size:" +engineers.size());

        engineers.printAllElements();

    }
}
