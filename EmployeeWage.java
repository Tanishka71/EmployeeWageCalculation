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
        else {
        	return 0; 
    }  
    }
    
    
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
	 * @desc:calls the function calculateWage,checkPartFullTime and prints the daywise income & total income
	 */
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        Random random=new Random();
        int daysWorked=random.nextInt(21);
        int totalIncome=0,totalHours=0,i=1;
        while(i<=daysWorked && totalHours<=100) {
                int hoursWorked=random.nextInt(8)+1;

                    int check=checkPartFullTime(hoursWorked);
                    if(check ==1) {
                    	System.out.println(" Day "+i+" full time:160$");
                        totalIncome +=(full_day * WAGE_PER_HOUR);	
                        totalHours +=full_day;
                        i++;
                    }
                    else {
                        int dailyWage=calculateWage(hoursWorked);
                        totalIncome +=dailyWage;
                        totalHours +=hoursWorked;
                 
                        System.out.println(" Day "+i+" part time:"+dailyWage+"$");
                         i++;
                    }
                 }
              	
        System.out.println("total salary:"+totalIncome+"$");
        System.out.println("total hours:"+totalHours+"hours");
    }

	
}
