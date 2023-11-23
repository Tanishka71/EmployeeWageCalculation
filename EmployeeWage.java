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
		 * @params:main
		 * @return:none
		 * @desc:creates object for random class and prints wage calling calculateWage function
		 */	 
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random=new Random();
        int hoursWorked=random.nextInt(9);
        if(hoursWorked == full_day && hoursWorked>0) {
        	System.out.println("Full time employee.");
        }
        else if(hoursWorked<8 && hoursWorked>0){
        	System.out.println("Part time employee."); 
    }
        else {
        	System.out.println("Employee is absent");
        }
        int dailyWage = calculateWage(hoursWorked);
        System.out.println("Daily Wage of this employee: $" + dailyWage);
}
}
