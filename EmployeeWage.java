package com.bridgelazbz.employee;

import java.util.*;

/*@desc:class for calculation of employee wage*/
class EmployeeWageCalculation {
	



	public EmployeeWageCalculation() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * @params:none
	 * @return:int
	 * @desc:takes input from the user
	 */	  
	static int inputDay() {
		System.out.println("Enter the full working gours for this company");
		Scanner sc=new Scanner(System.in);
		int full_day=sc.nextInt();
		return full_day;
	}
	
	/*
	 * @params:none
	 * @return:int
	 * @desc:takes input from the user
	 */	
	static int inputWage() {
		System.out.println("Enter the wage per hour for this company");
		Scanner sc=new Scanner(System.in);
		int WAGE_PER_HOUR=sc.nextInt();
		return WAGE_PER_HOUR;
	}
	
	
	/*
	 * @params:none
	 * @return:int
	 * @desc:takes input from the user
	 */	
	static int inputDaysWorked() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the days worked for this company");
		int daysWorked=sc.nextInt();
		return daysWorked;
	}
	
	/*
	 * @params:none
	 * @return:integer(1/0)
	 * @desc:checks whether the employee is present or absent
	 */	  
	static int checkAttendance() {
		double attendanceValue = Math.random();
		if (attendanceValue > 0.5) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	/*
	 * @params:hoursWorked
	 * @return:integer(1/0)
	 * @desc:checks whether the employee is full time or part time
	 */	  
    private static int checkPartFullTime(int full_day,int hoursWorked) {
        if(hoursWorked == full_day && hoursWorked>0) {
        	return 1;
        }
        else {
        	return 0; 
    }    
    }
    
    
	/*
	 * @params:hoursWorked
	 * @return:integer(dailyWage of the employee)
	 * @desc:calculates the daily wage of the employee
	 */	  
    static int calculateWage(int hoursWorked , int WAGE_PER_HOUR) {
        int dailyWage = hoursWorked * WAGE_PER_HOUR;
        return dailyWage;
    }
    
   
     
	/*
	 * @params:daysWorked
	 * @return:none
	 * @desc:calls the function checkAttendance ,calculateWage,checkPartFullTime and prints the daywise income & total income
	 */	 
    static void monthlyAmount(){
    	Random random=new Random();
    	int full_day=inputDay();
    	int WAGE_PER_HOUR=inputWage();
    	int daysWorked1=inputDaysWorked();
        int totalIncome=0,totalHours=0,i=1;
        while(i<=daysWorked1 && totalHours<=100) {
        	    int presence=checkAttendance();
        	    if(presence ==1) {
                    int hoursWorked=random.nextInt(full_day)+1;
					int check=checkPartFullTime(full_day,hoursWorked);
                    if(check ==1) {
                    	System.out.println(" Day "+i+" full time:160$");
                       
						totalIncome +=(full_day * WAGE_PER_HOUR);	
                        totalHours +=full_day;
                        i++;
                    }
                    else {
                        int dailyWage=calculateWage(hoursWorked, WAGE_PER_HOUR);
                        totalIncome +=dailyWage;
                        totalHours +=hoursWorked;
                 
                        System.out.println(" Day "+i+" part time:"+dailyWage+"$");
                         i++;
                    }
        	    }
        	    else {
        	    	System.out.println(" Day "+i+" employee is absent:");
        	    	i++;
        	    }
            	
                }
        System.out.println(" total salary:"+totalIncome+"$");
        System.out.println(" total hours:"+totalHours+"hours");
    }

}
/*@desc:main class*/
    class EmployeeWage{
	/*
	 * @params:main
	 * @return:none
	 * @desc:creates object for random class and takes days randomly
	 */	 
    public static void main(String[] args){
        System.out.println("Welcome to EMPLOYEE WAGE COMPUTATION PROGRAM!!");
        System.out.println();
        Random random=new Random();
        int daysWorked=random.nextInt(21);
        EmployeeWageCalculation obj=new EmployeeWageCalculation();
        obj.monthlyAmount();

    }
	
}
