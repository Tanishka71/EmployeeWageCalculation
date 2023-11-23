package EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	static final int WAGE_PER_HOUR=20;
	static final int full_day=8;
	
	/*
	 * @params:hoursWorked
	 * @return:integer(dailyWage of the employee)
	 * @desc:calculates the daily wage of the employee
	 */	  
     static int calculateWage(int hoursWorked) {
        int dailyWage = hoursWorked * WAGE_PER_HOUR;
        return dailyWage;
    }
     
     
 	/*
 	 * @params:none
 	 * @return:none
 	 * @desc:calculates the dialy wage
 	 */	 
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random=new Random();
        int hoursWorked=random.nextInt(9);
        int dailyWage = calculateWage(hoursWorked);
        System.out.println("Daily Wage of this employee: $" + dailyWage);
}
}
