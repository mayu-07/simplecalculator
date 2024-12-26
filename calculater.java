import java.util.*;
public class calculater 
{
    public static void main(String[]args){
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.println("Enter an operator (+,-,*,/) ");
        char op = input.next().charAt(0);

        switch(op){

            case '+' : System.out.println ( num1 + num2 );
            case '-'  : System.out.println ( num1 - num2) ;
            case '*' : System.out.println (num1 * num2) ;
            case '/' : System.out.println  ( num1 / num2) ;

            default : System.out.println("Invalid operator");
                
            


      }
    
    }
}