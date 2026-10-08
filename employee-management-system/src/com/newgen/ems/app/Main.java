package com.newgen.ems.app;

import com.newgen.ems.model.*;
import com.newgen.ems.repository.EmployeeRepository;



public class Main {


    public static void main(String[] args) {
        System.out.println("---Employee Management System Application---");
        Manager manager = new Manager("Asha Rao","Engineering",90000,101,true,6);
        Developer developer = new Developer("Himanshu Pradhan","Engineering",80000,102,true,"Java");
        Developer developer1 = new Developer("Rahul Verma","Engineering",78000,103,true,"Python");
        Intern intern = new Intern("Priya Singh","Engineering",15000,105,true,"Asha Rao");
        EmployeeRepository employeeRepository = new EmployeeRepository(2);

        // Add Employees

        employeeRepository.add(manager);
        employeeRepository.add(developer);
        employeeRepository.add(developer1);
        employeeRepository.add(intern);

         // Display payslip
        for (Employee employee: employeeRepository.findAll()){
            printPayslip(employee);
        }
         // find employee by ID
        int searchId = 103;

        Employee found = employeeRepository.findById(searchId);

        if (found != null) {
            System.out.println("Found employee " + searchId + ": " + found.designation());
        } else {
            System.out.println("Employee not found: " + searchId);
        }


//        try {
//            Employee found = employeeRepository.findById(searchId);
//            System.out.println("Found employee " + searchId + ": " + found.designation());
//        } catch (EmployeeNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        // performance grade
        char performanceGrade = 'A';
        double bonusMultiplier = switch (performanceGrade) {
            case 'A' -> 0.20;
            case 'B' -> 0.10;
            default -> 0.0;
        };
        System.out.printf("%nBonus multiplier for grade %c: %.0f%%%n", performanceGrade, bonusMultiplier * 100);

          // stock grant  eligibility
        if (developer.getBasesalary() > 50_000 && developer.isActive()) {
            System.out.println(developer.getName() + " is eligible for the annual stock grant.");
        }
         //promotion
        Promotable[] promotables = {manager, developer,developer1};

        for (Promotable promotable : promotables) {
            promotable.promote();
        }
             // Year-to-date salary
        double yearToDate = 0;
        for (int month = 1; month <= 12; month++) {
            yearToDate += manager.calculateMonthlySalary();
        }
        System.out.printf("%n%s year-to-date earnings after 12 months: %.2f%n", manager.getName(), yearToDate);

       // demonstrateObjectMethods(manager, developer, employeeRepository);
     //   demonstrateWrapperClasses(employeeRepository);


        System.out.println();
        System.out.println("=== Section 13/14: over to you (Scanner input, now with exception handling) ===");
      //  runConsoleMenu(employeeRepository);




    }
    private static void printPayslip(Employee employee) {
        String payslip = String.format("""
                --------------------------------
                Payslip for %-15s
                Designation : %s
                Department  : %s
                Monthly Pay : %.2f
                --------------------------------
                """, employee.getName(), employee.designation(),
                employee.getDepartment(), employee.calculateMonthlySalary());
        System.out.println(payslip);
    }

}
