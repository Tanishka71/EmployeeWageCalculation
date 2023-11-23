package EmployeeWage;

import java.util.Random;

public class EmployeeWage {
	static final int WAGE_PER_HOUR=20;
	static final int full_day=8;
	
	/*
	 * @params:hoursWorked
	 * @return:integer(1/0)
	 * @desc:checks whether the employee is full time or part time
	 */
    private static int checkPartFullTime(int hoursWorked) {
        if(hoursWorked == full_day && hoursWorked>0) {
        	return 1;
        }
        else if(hoursWorked < full_day && hoursWorked>0){
        	return 0; 
    }
        else {
        	return -1;
        } 
    }
    
    
	/*
	 * @params:hoursWorked
	 * @return:returns daily wage
	 * @desc:calls the function checkPartFulltime and calculates the daily wage using switch case
	 */
	   private static int calculateDailyWage(int hoursWorked) {
	        
	        int check=checkPartFullTime(hoursWorked);
	        int dailyWage;
	        switch (check) {
	            case 1:
	            	System.out.println("Full time employee.");
	                dailyWage=WAGE_PER_HOUR * hoursWorked;
	                break;
	            case 0:
	            	System.out.println("Part time employee."); 
	            	 dailyWage=WAGE_PER_HOUR * hoursWorked;
	                break;
	            case -1:
	                System.out.println("Employee is absent.");
	                dailyWage= 0;
	                break;
	             default:
	            	 System.out.println("Invalid input.");
	            	 return 0;
	        }
	        return dailyWage;
	    }
	   
		/*
		 * @params:none
		 * @return:none
		 * @desc:prints the wage of the employee
		 */
	    public static void main(String[] args){
	        System.out.println("Welcome to Employee Wage Computation Program");
	        Random random=new Random();
	        int hoursWorked=random.nextInt(9);
	        int dailyWage=calculateDailyWage(hoursWorked);
	        System.out.println("The wage of the employee is:$"+dailyWage);

	    }
}
