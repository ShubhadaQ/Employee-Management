package com.newgen.ems.model;

public class Intern extends Employee {

    private  String mentorName;

    public Intern(String name, String department, double basesalary, int id, boolean active,String mentorName) {
        super(name, department, basesalary, id, active);
        this.mentorName = mentorName;
    }

    @Override
    public String designation() {
        return "Intern";
    }

}
