package com.newgen.ems.model;

public interface Promotable {
    String nextRole();

    default void promote(){
        System.out.println(" Congratulations! You Are Being Promotable to  " + nextRole());
    }
}
