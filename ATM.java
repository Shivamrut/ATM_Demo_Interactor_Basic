import java.util.ArrayList;
import java.util.Scanner;


class ATM{

    ArrayList<Users> users = new ArrayList<Users>();
    int cur;
    public ATM()
    {
        // Users p1 = new Users(1,1234,"Monkey D Luffy",3000);
        users.add(new Users(1,1111,"Monkey D Luffy",3000));
        users.add(new Users(2,2222,"Roronoa Zoro",5000));
        users.add(new Users(3,3333,"Vinsmoke Sanji",10000));
        users.add(new Users(4,4444,"Portgas D Ace",300000));
    }
    
    public Boolean Authorise(Scanner sc)
    {
        System.out.println("Please Enter Your Account Number And PIN to continue");
        System.out.print("Account Number: ");
        int ac_num = sc.nextInt();
        System.out.print("PIN: ");
        int pin = sc.nextInt();
        for(Users u : users)
        {
            if(u.ac_num==ac_num && u.pin == pin){
                this.cur = ac_num;
                return true;
            }
        }
        System.out.println("Wrong credentials!!!!");
        return false;
        
    }

    public void Clear_Screen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public void Main_Menu()
    {  
        System.out.println("Please Select What Would You Like To Do");
        System.out.println("1.Deposit Money\n2.Withdraw Money\n3.Check Balance\n4.Exit");
    }
    public void Perform_Function(int val, Scanner sc)
    {
        switch(val)
        {
            case 1:
                Deposit(sc);
                break;

            case 2:
                Withdraw(sc);
                break;
            
            case 3:
                Check_Balance(sc);
                break;

            default:
                Print_Error();
                break;
        }
    }
    public void Deposit(Scanner sc){
        System.out.println("Please deposit amount between 500 to 10000 berries");
        System.out.println("Enter the amount you want to deposit: ");
        int amount = sc.nextInt();
        if(amount<500 || amount > 10000)
        {
            System.out.println("Enter amount within limits");
            return;
        }
        System.out.println("Depositing money!");
        for(Users u : users)
        {
            if(u.ac_num == cur)
            {
                u.balance += amount;
                break;
            }
        }
    }
    public void Withdraw(Scanner sc){
        System.out.println("Please withdraw amount between 500 to 5000 berries");
        System.out.println("Enter the amount you want to withdraw: ");
        int amount = sc.nextInt();
        if(amount<500 || amount > 5000)
        {
            System.out.println("Enter amount within limits");
            return;
        }
        System.out.println("Withdrawing money!");
        for(Users u : users)
        {
            if(u.ac_num == cur)
            {
                u.balance -= amount;
                break;
            }
        }
    }
    public void Check_Balance(Scanner sc){
        for(Users u : users)
        {
            if(u.ac_num == cur)
            {
                System.out.println("Your Balance is : " + u.balance);
                break;
            }
        }
        
    }
    public void Print_Error()
    {
        System.out.println("There is some technical issue. Please try again!!");
    }
    public void Welcome_User()
    {
        for(Users u : users)
        {
            if(u.ac_num == cur)
            {
                System.out.println("Welcome "+u.full_name+". Please continue your transaction.");
                break;
            }
        }
    }
}

