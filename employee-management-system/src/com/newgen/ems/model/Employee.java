package com.newgen.ems.model;

public abstract class Employee implements Payable{

    private final int id;
    private String name;
    private String department;
    protected double basesalary;
    private boolean active;

    public Employee(String name, String department, double basesalary, int id, boolean active) {
        this.name = name;
        this.department = department;
        this.basesalary = basesalary;
        this.id = id;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(double basesalary) {
        this.basesalary = basesalary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract String designation();
    @Override
    public double calculateMonthlySalary(){
        return basesalary;
    }
}
