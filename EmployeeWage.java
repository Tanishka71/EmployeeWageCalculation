
package com.bridgelazbz.employee;

import java.util.*;


import java.util.Scanner;
import java.util.Random;

/*@desc: Class for calculation of employee wage */
class EmpWageBuilder {

    // Instance variables for each company
    private final String companyName;
    private final int wagePerHour;
    private final int fullDayHours;

    // Instance variables to store total wage and total hours
    private int totalWage;
    private int totalHours;

    /*
     * @desc: Constructor to initialize company-specific details
     * @params: companyName - Name of the company
     *          wagePerHour - Wage per hour for the company
     *          fullDayHours - Full working hours for the company
     */
    public EmpWageBuilder(String companyName, int wagePerHour, int fullDayHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
    }

    /*
     * @desc: Simulates monthly wage calculation
     * @params: daysWorked - Number of days worked for the company
     * @return: None
     */
    public void calculateMonthlyWage(int daysWorked) {
        Random random = new Random();
        int i = 1;
        while (i <= daysWorked && totalHours <= 100) {
            int presence = checkAttendance();
            if (presence == 1) {
                int hoursWorked = random.nextInt(fullDayHours) + 1;
                int check = checkPartFullTime(hoursWorked);
                if (check == 1) {
                    System.out.println(" Day " + i + " for " + companyName + " full time: " + fullDayHours * wagePerHour + "$");
                    totalWage += (fullDayHours * wagePerHour);
                    totalHours += fullDayHours;
                } else {
                    int dailyWage = calculateWage(hoursWorked);
                    totalWage += dailyWage;
                    totalHours += hoursWorked;

                    System.out.println(" Day " + i + " for " + companyName + " part time: " + dailyWage + "$");
                }
                i++;
            } else {
                System.out.println(" Day " + i + " for " + companyName + " employee is absent");
                i++;
            }
        }
        // Print total salary and total hours worked for the company
        System.out.println(" Total salary for " + companyName + ": " + totalWage + "$");
        System.out.println(" Total hours worked for " + companyName + ": " + totalHours + " hours");
    }

    /*
     * @desc: Checks whether the employee is present or absent
     * @return: 1 for present, 0 for absent
     */
    private int checkAttendance() {
        double attendanceValue = Math.random();
        return attendanceValue > 0.5 ? 1 : 0;
    }

    /*
     * @desc: Checks whether the employee is full time or part time
     * @params: hoursWorked - Number of hours worked by the employee
     * @return: 1 for full time, 0 for part time
     */
    private int checkPartFullTime(int hoursWorked) {
        return hoursWorked == fullDayHours && hoursWorked > 0 ? 1 : 0;
    }

    /*
     * @desc: Calculates the daily wage based on the hours worked
     * @params: hoursWorked - Number of hours worked by the employee
     * @return: Daily wage of the employee
     */
    private int calculateWage(int hoursWorked) {
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

        // Get details for Company1 from the user
        System.out.println("Enter details for Company1:");
        System.out.print("Company Name: ");
        String company1Name = scanner.next();
        System.out.print("Wage Per Hour: ");
        int company1WagePerHour = scanner.nextInt();
        System.out.print("Full Day Hours: ");
        int company1FullDayHours = scanner.nextInt();

        // Get details for Company2 from the user
        System.out.println("Enter details for Company2:");
        System.out.print("Company Name: ");
        String company2Name = scanner.next();
        System.out.print("Wage Per Hour: ");
        int company2WagePerHour = scanner.nextInt();
        System.out.print("Full Day Hours: ");
        int company2FullDayHours = scanner.nextInt();

        // Create instances of EmpWageBuilder for each company
        EmpWageBuilder company1 = new EmpWageBuilder(company1Name, company1WagePerHour, company1FullDayHours);
        EmpWageBuilder company2 = new EmpWageBuilder(company2Name, company2WagePerHour, company2FullDayHours);

        // Get the number of days worked for each company from the user
        System.out.print("Enter number of days worked for " + company1Name + ": ");
        int company1DaysWorked = scanner.nextInt();
        company1.calculateMonthlyWage(company1DaysWorked);

        System.out.print("Enter number of days worked for " + company2Name + ": ");
        int company2DaysWorked = scanner.nextInt();
        company2.calculateMonthlyWage(company2DaysWorked);

        // Close the scanner
        scanner.close();
    }
}
