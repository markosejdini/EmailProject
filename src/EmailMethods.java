import java.util.*;
import java.io.*;
public class EmailMethods {
    public Scanner s = new Scanner(System.in);
    private String fname;
    private String lName;
    private String Dept;
    private String email;
    private String password;
    private int mailCapacity =500;
    private String alterEmail;

    public EmailMethods (String fname, String lName){
        this.fname=fname;
        this.lName=lName;
        this.Dept= this.setDept();
        this.password=this.generatePassword(9);
        this.email= this.emailGenerating();

        System.out.println("The name is: " +fname+" "+lName);
    }

    private String emailGenerating () {
        return this.fname.toLowerCase()+"."+lName.toLowerCase()+"@"+Dept.toLowerCase()+"great.com" ;
    }

    private String setDept () {
        System.out.println("Chose department: \n 1. Sales \n 2. Developing \n 3. Accounting");
        boolean flag = false;
        do {


            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Developing";
                case 3:
                    return "Accounting";
                case 0:
                    return "none";
            }


        }while (!flag);
        return null;
    }

    private String generatePassword (int length) {
        Random random = new Random();
        String capitalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase= "abcdefghijklmnopqrstuvwxyz";
        String numbers= "0123456789";
        String symbol= "!@#$%^&*?";
        String values= capitalAlphabet+lowercase+numbers+symbol;
        String password= "";
        for(int i =0; i<length; i++) {
            password= password+values.charAt(random.nextInt(values.length()));
        }
        return password;
    }
    public void changePassword() {
        boolean flag = false;

        do {
            System.out.println("Change the pasword? Y/N");
            char choice = s.next().charAt(0);
            if(choice== 'Y' || choice=='y') {
                flag= true;
                System.out.println("Enter the current password");
                String temp = s.next();
                if(temp.equals(this.password)){
                    System.out.println("enter the new password");
                    this.password=s.next();
                    System.out.println("password changed");
                }else {
                    System.out.println("incorrect password");
                }
            } else if (choice== 'N'|| choice=='n') {
                System.out.println("thank you for cancellation");
                flag=true;
            }else {
                System.out.println("you typed wrong");
            }
        }while (!flag);
    }
    public void changeMailCapacity () {
        System.out.println("Current capacity is: "+ this.mailCapacity+ "mb");
        System.out.println("add the new capacity");
        this.mailCapacity= s.nextInt();
        System.out.println("capacity changed");
    }
    public void putAlternateEmail() {
        System.out.println("enter the alternative email");
        this.alterEmail=s.next();
        System.out.println("added");
    }
    public void getInfo () {
        System.out.println("new"+ this.fname+" "+ this.lName);
        System.out.println("department"+this.Dept);
        System.out.println("Email"+ this.email);
        System.out.println("Password"+ this.password);
        System.out.println("Mail Capacity" +this.mailCapacity);
        System.out.println("Other email"+ this.alterEmail);
    }

    public void storeFile (){
        try {
            FileWriter in = new FileWriter("C:\\Users\\user\\OneDrive\\Desktop\\hey");
            in.write("name: "+ this.fname);
            in.append("\n last name: "+ this.lName);
            in.append("\n email: "+ this.email);
            in.append("\n password: "+ this.password);
            in.append("\n email capacity: "+ this.mailCapacity);
            in.append("\n alternate email: "+ this.alterEmail);
            in.close();
            System.out.println("data stored");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void readFile(){
        try{
            FileReader re = new FileReader("C:\\Users\\user\\OneDrive\\Desktop\\hey");
            int i;
            while ((i= re.read())!= -1) {
                System.out.print((char) i);
            }
            re.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
