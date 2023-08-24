package emailapp;

import java.util.Scanner;

public class Email {
    //creating variable as private to avoid direct access
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;

    // Constructor to receive firstName and LastName
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //calling a method to ask for department and return it
        this.department = setDepartment();
        System.out.println("Department : "+ this.department);

        // call a method to return random password

    }

    //ask for department
    private String setDepartment(){
        System.out.print("Department codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if(deptChoice==1) return "Sales";
        else if (deptChoice==2) return "Development";
        else if (deptChoice==3) return "Accounting";
        else return "";
    }

    // Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int randomValue = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(randomValue);
        }
    }
}
