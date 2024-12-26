import java.io.*;
import java.util.Scanner;
import java.util.Vector;

  class bank {
   static Account searchAccount(Vector<Account> vec,int AN)
   {
      Account ACC=null;
      for(int i=0;i<vec.size();i++)
      {
         ACC=(Account)vec.elementAt(i);
         if(ACC.getAccountNo()==AN)
           break;
      }
      return ACC;
   }


   
/**
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception
    {
        Scanner scan=new Scanner(System.in);
        Vector<Account> vec=new Vector<>();
        int cmd;
        do{
        System.out.println("--------------------------");
        System.out.println("\tBanking System");
        System.out.println("------------------------------");
        System.out.println("1.Create New Account");
        System.out.println("2.show Balance");
        System.out.println("3.Deposite");
        System.out.println("4.Withdraw");
        System.out.println("5.Interest");
        System.out.println("6.List Account");
        System.out.println("7.Save");
        System.out.println("8.Load");
        System.out.println("9.Exit");
        System.out.println("---------------------------");
        System.out.print("Enter command");
         cmd = scan.nextInt();
         int AN,AT,NY;
         double BL;
         String FN,LN;
         Account ACC;
         switch (cmd)
         {
            case 1 -> {
                System.out.print("Enter First Name");
                FN=scan.next();
                System.out.print("Enter last Name");
                LN=scan.next();
                System.out.print("Enter Account No.");
                AN=scan.nextInt();
                System.out.print("Enter Balance");
                BL=scan.nextInt();
                ACC=new Account(FN,LN,AN,BL);
                vec.add(ACC);
                System.out.println("Account created successfully");
             }
             case 2 -> {
                 System.out.println("Enter Account No. ");
                 AN=scan.nextInt();
                 ACC=searchAccount(vec, AN);
                 ACC.showBalance();
           }
           case 3 -> {
               System.out.print("Enter Account No.");
               AN=scan.nextInt();
               System.out.print("Enter Amount");
               AT=scan.nextInt();
               ACC=searchAccount(vec, AN);
               if(ACC==null)
                   System.out.print("Account Not Found ");
               else
                   ACC.deposit(AT);
                }
                case 4 -> {
                    System.out.print("Enter Account No.");
                    AN=scan.nextInt();
                    System.out.println("Enter Amount");
                    AT=scan.nextInt();
                    ACC=searchAccount(vec, AN);
                    if(ACC==null)
                        System.out.println("Account Not Found");
                    else
                        ACC.withdraw(AT);
                }
                case 5 -> {
                    System.out.print("Enter Account No.");
                    AN=scan.nextInt();
                    System.out.print("Enter Rate of Interest");
                    double RT=scan.nextDouble();
                    System.out.print("Enter Number of years:");
                     NY=scan.nextInt();
                    ACC=searchAccount(vec,AN);
                    if(ACC==null)
                        System.out.println("Account Not Found");
                    else
                        ACC.addinterest(RT,NY);
                }
                    case 6 -> {
                        System.out.printf("| %10s | %15s | %10s |\n","Account No","Name","Balance");
                        for(Account item:vec)
                        {
                            AN=item.getAccountNo();
                            FN=item.getFName();
                            LN=item.getLName();
                            BL=item.getBalance();
                            System.out.printf("| %10d | %15s | %10.2f |\n",AN,FN+" "+LN,BL);
                        }
                }
                 case 7 -> {
                     FileOutputStream fileout=new FileOutputStream("data.obj");
                     ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileout);
                     objectOutputStream.writeObject(vec);
                     System.out.println("Data stored....");
                }
                case 8 -> {
                    FileInputStream file=new FileInputStream("data.obj");
                    ObjectInputStream objectInputStream=new ObjectInputStream(filein);
                    vec=(Vector)objectInputStream.readObject();
                    System.out.println("Data Loaded....");
                }
                    

             }
      try{
      System.out.println("Press ENTER to continue....");
      System.in.read();
      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      }catch(Exception e)
      {
        System.out.println(e);

      }
          }while(cmd!=9);

        
   } 

    
    
}
