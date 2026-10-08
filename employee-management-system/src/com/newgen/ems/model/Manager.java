package com.newgen.ems.model;

public class Manager extends Employee implements Promotable {


    private int teamSize;


    public Manager(String name, String department, double basesalary, int id, boolean active,int teamSize) {
        super(name, department, basesalary, id, active);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public double calculateMonthlySalary(){
        double teambonus = teamSize * 50.0;
                return basesalary + teambonus;

    }


    @Override
    public String designation() {
        return "Manager";
    }
    @Override
    public String nextRole(){

        return "Senior Manager";
    }
}
