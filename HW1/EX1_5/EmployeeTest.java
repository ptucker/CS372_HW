import java.util.*;

public class EmployeeTest{
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Kyle Shepard","Sep 4th, 2017","student","Pete Tucker");
        employees[1] = new Employee("Petes McGetes","some day in the 20th century","CS Professor","Beck Taylor");

/*
        Scanner scnr = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Employee Name:");
        String name = scnr.next();
        System.out.println("Hire Date:");
        String date = scnr.next();
        System.out.println("Position:");
        String position = scnr.next();
        System.out.println("Manager of Employee:");
        String manager = scnr.next();
*/
        employees[2] = new Employee();

        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i].toString());
        }
    }
}