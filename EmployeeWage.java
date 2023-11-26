package com.bridgelazbz.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


interface EmpWageBuilderInterface{
	void addCompanyEmpWage(CompanyEmpWage companyEmpWage, int index);
	void calculateEmployeeWage();
}


/*@desc: Class to represent employee wage details for a company */
class CompanyEmpWage {

    private final String companyName;
    private final int wagePerHour;
    private final int fullDayHours;
    private final int daysWorked;

    // Constructor
    public CompanyEmpWage(String companyName, int wagePerHour, int fullDayHours, int daysWorked) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
        this.daysWorked = daysWorked;
    }

    // Getters
    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getFullDayHours() {
        return fullDayHours;
    }

    public int getDaysWorked() {
        return daysWorked;
    }
}

/*@desc: Class to manage employee wages for multiple companies */
class EmpWageBuilder implements EmpWageBuilderInterface {

    // List of CompanyEmpWage objects
    private final List<CompanyEmpWage> companyEmpWages;

    // Constructor
    public EmpWageBuilder(int numOfCompanies) {
        companyEmpWages = new ArrayList<>();
    }

    // Add company details to the list
    public void addCompanyEmpWage(CompanyEmpWage companyEmpWage, int index) {
        companyEmpWages.add(companyEmpWage);
    }

    // Calculate employee wage for each company
    public void calculateEmployeeWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            calculateMonthlyWage(companyEmpWage);
        }
    }

    // Simulate monthly wage calculation for a company
    private void calculateMonthlyWage(CompanyEmpWage companyEmpWage) {
        Random random = new Random();
        int totalWage = 0, totalHours = 0, i = 1;
        while (i <= companyEmpWage.getDaysWorked() && totalHours <= 100) {
            int presence = checkAttendance();
            if (presence == 1) {
                int hoursWorked = random.nextInt(companyEmpWage.getFullDayHours()) + 1;
                int check = checkPartFullTime(hoursWorked, companyEmpWage.getFullDayHours());
                if (check == 1) {
                    System.out.println(" Day " + i + " for " + companyEmpWage.getCompanyName() +
                            " full time: " + companyEmpWage.getFullDayHours() * companyEmpWage.getWagePerHour() + "$");
                    totalWage += (companyEmpWage.getFullDayHours() * companyEmpWage.getWagePerHour());
                    totalHours += companyEmpWage.getFullDayHours();
                } else {
                    int dailyWage = calculateWage(hoursWorked, companyEmpWage.getWagePerHour());
                    totalWage += dailyWage;
                    totalHours += hoursWorked;

                    System.out.println(" Day " + i + " for " + companyEmpWage.getCompanyName() +
                            " part time: " + dailyWage + "$");
                }
                i++;
            } else {
                System.out.println(" Day " + i + " for " + companyEmpWage.getCompanyName() + " employee is absent");
                i++;
            }
        }
        // Print total salary and total hours worked for the company
        System.out.println(" Total salary for " + companyEmpWage.getCompanyName() + ": " + totalWage + "$");
        System.out.println(" Total hours worked for " + companyEmpWage.getCompanyName() + ": " + totalHours + " hours");
    }

    // Checks whether the employee is full time or part time
    private int checkPartFullTime(int hoursWorked, int fullDayHours) {
        return hoursWorked == fullDayHours && hoursWorked > 0 ? 1 : 0;
    }

    // Checks whether the employee is present or absent
    private int checkAttendance() {
        double attendanceValue = Math.random();
        return attendanceValue > 0.5 ? 1 : 0;
    }

    // Calculates the daily wage based on the hours worked
    private int calculateWage(int hoursWorked, int wagePerHour) {
        return hoursWorked * wagePerHour;
    }
}

public class EmployeeWage {

    /*
     * @desc: Main method to execute the employee wage computation program
     * @params: args - command-line arguments (not used in this program)
     * @return: None
     */
    public static void main(String[] args) {
        System.out.println("Welcome to EMPLOYEE WAGE COMPUTATION PROGRAM!!");
        System.out.println();

        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of companies from the user
        System.out.print("Enter the number of companies: ");
        int numOfCompanies = scanner.nextInt();

        // Create an instance of EmpWageBuilder
        EmpWageBuilder empWageBuilder = new EmpWageBuilder(numOfCompanies);

        // Get details for each company and add them to the EmpWageBuilder
        for (int i = 0; i < numOfCompanies; i++) {
            System.out.println("Enter details for Company " + (i + 1) + ":");
            System.out.print("Company Name: ");
            String companyName = scanner.next();
            System.out.print("Wage Per Hour: ");
            int wagePerHour = scanner.nextInt();
            System.out.print("Full Day Hours: ");
            int fullDayHours = scanner.nextInt();
            System.out.print("Days Worked: ");
            int daysWorked = scanner.nextInt();

            // Create an instance of CompanyEmpWage
            CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, wagePerHour, fullDayHours, daysWorked);

            // Add the company details to the EmpWageBuilder
            empWageBuilder.addCompanyEmpWage(companyEmpWage, i);
        }

        // Close the scanner
        scanner.close();

        // Calculate employee wage for each company
        empWageBuilder.calculateEmployeeWage();
    }
}
