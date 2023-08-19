import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);
        atm.Clear_Screen();
        System.out.println("Welcome to maxus_red atm1.0");
        if(atm.Authorise(sc))
        {
            atm.Welcome_User();
            while(true)
            {
                
                atm.Main_Menu();
                
                
                int choice = sc.nextInt();
                // System.out.println(choice);
                
                if(choice>0 && choice<5){
                    // start 
                    if(choice==4)
                    {
                        atm.Clear_Screen();
                        System.out.println("Thank You for using maxus_red atm1.0.\nPlease visit again!!");
                        break;
                    }
                    atm.Clear_Screen();
                    atm.Perform_Function(choice,sc);
                    System.out.println("\n");
                    
                }
                else{
                    System.out.println("Please enter valid option");
                }
                
            
            }
        }
        else{
            System.out.println("Failed Authentication!!!!!");
        }
        sc.close();


    }
}