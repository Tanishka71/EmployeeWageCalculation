package EmployeeWage;

public class EmployeeWage {
	/*
	 * @params:hoursWorked
	 * @return:none
	 * @desc:checks whether the employee is full time or part time
	 */	 
    private static void checkAttendance() {
        double attendanceValue = Math.random();

        if (attendanceValue > 0.5) {
            System.out.println("Employee is present.");
        } else {
            System.out.println("Employee is absent.");
        }
    }
    
 	/*
 	 * @params:none
 	 * @return:none
 	 * @desc:prints whether employee is present or absent
 	 */	 
    public static void main(String[] args){
        System.out.println("ATTENDANCE of the employee:");
        checkAttendance();
    }
}
