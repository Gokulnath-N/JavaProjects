package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    //creating variable as private to avoid direct access
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix ="somecompany.com";

    // Constructor to receive firstName and LastName
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //calling a method to ask for department and return it
        this.department = setDepartment();

        // call a method to return random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase()+"@"+ department +"."+ companySuffix;
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
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password)
    {
        this.password = password;
    }

    public int getMailboxCapacity()
    {
        return mailboxCapacity;
    }
    public String getAlternateEmail()
    {
        return alternateEmail;
    }
    public String getPassword()
    {
        return password;
    }
    public String showInfo()
    {
        return "Display Name: "+ firstName +" "+ lastName +
        "\nCompany Email: "+ email +
        "\nMailbox Capacity: " + mailboxCapacity +"mb";
    }
}
