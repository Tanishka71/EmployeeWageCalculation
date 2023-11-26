package com.bridgelazbz.employee;

import java.util.Random;

/*@desc:class for calculation of employee wage*/
class EmployeeWageCalculation {
	static final int WAGE_PER_HOUR=20;
	static final int full_day=8;
	int daysWorked;
	
	EmployeeWageCalculation(int daysWorked){
		this.daysWorked=daysWorked;
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
	 * @params:daysWorked
	 * @return:none
	 * @desc:calls the function checkAttendance ,calculateWage,checkPartFullTime and prints the daywise income & total income
	 */	 
    static void monthlyAmount(int daysWorked){
    	Random random=new Random();
        int totalIncome=0,totalHours=0,i=1;
        while(i<=daysWorked && totalHours<=100) {
        	    int presence=checkAttendance();
        	    if(presence ==1) {
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
        EmployeeWageCalculation obj=new EmployeeWageCalculation(daysWorked);
        obj.monthlyAmount(daysWorked);

    }
	
}
