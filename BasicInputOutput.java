
import java.util.Scanner;

public class BasicInputOutput {
    public static void main(String[] args) {

        int a;
        double b;
        String c;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        c = sc.nextLine();

        System.out.println("Enter the Integer: ");
        a=sc.nextInt();

        System.out.println("Enter the Double: ");
        b=sc.nextDouble();

        //If you write sc= c.nextLine() just after a=sc.nextInt(); b=sc.nextDouble(); then it won't show the string
        // The reason why your Java code wont display the string value correctly is because of how the Scanner class handles input.
        // When you use sc.nextLine() to read a string, it consumes the newline character left in the input buffer
        // from the previous nextInt() and nextDouble() calls, without waiting for you to enter a string
        //To fix this issue, either you can write c= sc.nextLine() at first or you can add an extra sc.nextLine() call after reading the double value
        // to consume the leftover newline character, and then you can proceed to read the string.


        System.out.println("String value =" +" "+c);
        System.out.println("integer value ="+" " +a);
        System.out.println("double value ="+" "+b);

        // close scanner
        sc.close();


    }
}