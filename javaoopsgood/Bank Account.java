import java.util.*;

class Bank{

    String name;

    int balance;

    int accountno;

    public Bank(String name){

        this.name=name;

        this.balance=0;

    }

    public void deposit(int amount){

        balance+=amount;

    }

    public void withdraw(int money){

        if(balance<money)

            System.out.println("Negative Balance Transaction Cancelled");

        else

            balance-=money; 

    }

    public void display(){

        System.out.println(accountno+" "+name+" "+balance);

    }

    public void setAccno(int num){

        this.accountno=num;

    }

}

public class Solution {

 

    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        int num=Integer.parseInt(in.nextLine());

        String nam=in.nextLine();

        int a=Integer.parseInt(in.nextLine());

        Bank b=new Bank(nam);

        b.setAccno(num);

        for(int i=0;i<a;i++){

            String[] arr=in.nextLine().split(" ");

            if(arr[0].equals("Deposit"))

                b.deposit(Integer.parseInt(arr[1]));

            else if(arr[0].equals("Withdraw"))

                b.withdraw(Integer.parseInt(arr[1]));

            else if(arr[0].equals("Display"))

                b.display();

            }

        }

    }
