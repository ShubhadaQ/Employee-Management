package com.newgen.ems.model;

public class Developer extends Employee implements Promotable {

   private String primaryLanguage;

    public Developer(String name, String department, double basesalary, int id, boolean active,String primaryLanguage) {
        super(name, department, basesalary, id, active);
        this.primaryLanguage = primaryLanguage;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

   // public double calculateMonthlySalary(){
//        primaryLanguage.equalsIgnoreCase(("Java") ||
//                primaryLanguage.equalsIgnoreCase("Python"));


//         double skillbonus = highDemandSkill ? basesalary * 0.10 : basesalary * 0.05;
//         return basesalary + skillbonus;

        @Override
        public double calculateMonthlySalary() {
            boolean highDemandSkill =
                    primaryLanguage.equalsIgnoreCase("Java") ||
                            primaryLanguage.equalsIgnoreCase("Python");

            double skillbonus = highDemandSkill
                    ? basesalary * 0.10
                    : basesalary * 0.05;

            return basesalary + skillbonus;
        }


    @Override
    public String designation() {
        return "Software Developer";
    }

    @Override
    public String nextRole() {
        return " Senior Developer";
    }
}
