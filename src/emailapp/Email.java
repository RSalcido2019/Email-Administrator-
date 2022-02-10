package emailapp;
import java.util.*;
import java.io.*;


public class Email {
    public Scanner s = new Scanner(System.in); //Scanner class is GLOBAL.   This class was obtained from the library java.util.*
    // Setting variables as private. This prevents direct access
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    //Constructor to receive first name, last name
    public Email(String fname, String lname){
        //copied the value from the private to this program
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee:" + this.fname+""+this.lname);
         //Calling methods
        this.dept = this.set_dept(); //Department
        this.password = this.generate_password(8); //Password
        this.email = this.generate_email(); //email generation
    }
    //Generate mail method {private allows abstraction}
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }
    //Asking for department
    private String serDept(){
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;

        do{
            System.out.println("Enter Department code");
            int choice =s.nextInt();
            switch(choice){
                case 1:
                    return "Sales";
                case 2:
                    return  "Development";
                case 3:
                    return  "Accounting";
                case 0:
                    return  "None";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        }while (!flag);
        return null;
    }
    //Generate Random password method
    private String generate_password(int length) {
        Random r = new Random();
        String Capital_chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Lower_chars ="abcdefghijklmnopqrstuvwxyz";
        String numbers ="0123456789";
        String symbols ="!@#$%^&*?";
        String values =Capital_chars+Lower_chars+numbers+symbols;
        String password="";
        for(int i=0; i<length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    //Change password method
    public void set_password(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password!? (Y/N)");
            char choice = s.next().charAt(0);
            if (choice== 'Y' || choice=='y'){
                flag = true;
                System.out.println("Enter current password");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect Password");
                }
            }else if(choice=='N' || choice=='n') {
               flag = true;
               System.out.println("Password changed request cancelled!!");
          }else{
                System.out.println("Enter Valid choice");
            }
        }while(!flag);
    }
    //set mailbox capacity method
    public void set_mailCap(){
        System.out.println("Current Capacity= "+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
    // set alternative email
    public void alternate_email(){
        System.out.println("Enter new alternate email: ");
        this.alter_email = s.next();
        System.out.println("Alternate email is set");
    }
    //Display user information method
    public void getUserInfo(){
        System.out.println("New:"+this.fname+" "+this.lname);
        System.out.println("Department:"+this.dept);
        System.out.println("Email:"+this.email);
        System.out.println("Password:"+this.password);
        System.out.println("Mailbox capacity"+this.mailCapacity+"mb");
        System.out.println("Alternate mail"+this.alter_email);
    }
}
