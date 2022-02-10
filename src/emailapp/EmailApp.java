package emailapp;
import java.util.*;

public class EmailApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //User info
        System.out.println("Enter first name:");
        String f_name = s.next();
        System.out.println("Enter last name:");
        String l_name = s.next();

        // creating object for Email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("\n ***********************\n Enter your choice\n1.Show Info\n2.Change Password\n3.Change mailbox capacity\n4. Set Alternative mail\n5.Store data File storage\n6.Display data in file.\n7.Exit");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getUserInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.readfile();
                    break;
                case 7:
                    System.out.println("Thank you for using application");
                    break;
                default:
                    System.out.println("Invalid choice!! \nEnter choice again: ");
            }
        }while (choice!=5);
    }
}
