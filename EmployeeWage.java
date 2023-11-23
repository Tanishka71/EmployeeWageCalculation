package EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	static final int WAGE_PER_HOUR=20;
	static final int full_day=8;
	
	
	/*
	 * @params:daysWorked
	 * @return:integer(dailyWage of the employee)
	 * @desc:calculates the monthly wage of the employee
	 */	
    public static int monthlyAmount(int daysWorked){
        int monthlyWage = WAGE_PER_HOUR * daysWorked;
        return monthlyWage;
    }
    
    
	/*
	 * @params:none
	 * @return:none
	 * @desc:calls the function monthly wage and prints the monthly income
	 */	 
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random=new Random();
        int daysWorked=random.nextInt(21);
        int monthlyWage = monthlyAmount(daysWorked);
    	System.out.println("The number of days this employee worked:"+ daysWorked);
        System.out.print("The monthly wage of full time employee: "+ monthlyWage);


    }
	
}
