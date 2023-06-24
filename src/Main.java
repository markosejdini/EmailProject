import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("add name");
        String name= sc.next();
        System.out.println("add surname");
        String surname= sc.next();

        EmailMethods em1 = new EmailMethods(name,surname);
        int choice = -1;

        do{
            System.out.println("chose \n 1. for info \n 2. chang password\n 3. change mail capacity \n 4. set alternative" +
                    "email. \n 5. store date in file \n 6. read data in file \n 7. exit ");
            choice= sc.nextInt();
            switch (choice){
                case 1 :
                    em1.getInfo();
                    break;
                case 2 :
                    em1.changePassword();
                    break;
                case 3 :
                    em1.changeMailCapacity();
                    break;
                case 4:
                    em1.putAlternateEmail();
                    break;
                case 7:
                    System.out.println("thank you");
                    break;
                case 5:
                    em1.storeFile();
                    break;
                case  6:
                    em1.readFile();
                    break;
                default:
                    System.out.println("you wrote wrong");

            }
        }while (choice!=7);


    }
}