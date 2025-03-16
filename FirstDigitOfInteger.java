import java.util.Scanner;

//This Java code is designed to read an integer from the user and then determine and print the first digit of that integer.

public class FirstDigitOfInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number:");
        int x = s.nextInt();
        int y = 0;
        while (x > 0) {
            y = x % 10;
            x = x / 10;
        }
        System.out.println("First digit is =" + y);
    }
}


//Explanation of Logic:

// Lets say, x = 100
//
//The while loop starts with x equal to 100.
//
//In the first iteration of the loop:
//
//y is assigned the value of x % 10, which is 100 % 10, so y becomes 0.
//x is updated to x / 10, which is 100 / 10, so x becomes 10.

//In the second iteration of the loop:

//y is assigned the value of x % 10, which is 10 % 10, so y becomes 0 again.
//x is updated to x / 10, which is 10 / 10, so x becomes 1.

//In the third and final iteration of the loop:

//y is assigned the value of x % 10, which is 1 % 10, so y becomes 1.
//x is updated to x / 10, which is 1 / 10, so x becomes 0.
//Now, the loop condition x > 0 is no longer true because x is 0. Therefore, the loop terminates.
//
//The program prints out the value of y, which is the first digit of the originally entered number, so it prints: "First digit is = 1"
//
//So, when x is set to 100, the program correctly identifies the first digit as 1 and prints it as the output.