
//This Java program is designed to find and print all integers between two given integers (inclusive) that are divisible by 10.
// It also counts and prints the total number of such integers

import java.util.Scanner;

public class DivisibleByTen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two integers:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int count=0;
        for (int i = x; i <= y; i++) {
            if (i%10==0) {
                count++;
                System.out.print(i+" ");
            }
        }System.out.println("total numbers = "+count);
    }
}

//int x = sc.nextInt();: This line reads an integer entered by the user and stores it in the variable x.
//
//int y = sc.nextInt();: This line reads another integer entered by the user and stores it in the variable y.
//
//int count = 0;: This line initializes a variable count to 0. This variable will be used to keep track of the count of numbers that are divisible by 10.
//
//for (int i = x; i <= y; i++) { ... }:
// This is a for loop that iterates through integers starting from x and ending at y.
//
// Inside the loop:

//if (i % 10 == 0) { ... }:
// This condition checks if the current value of i is divisible by 10 (i.e., if the remainder when dividing by 10 is 0).
//
//If i is divisible by 10, the code inside the if block is executed:
//count++: This increments the count variable by 1 to keep track of the count of numbers divisible by 10.
//System.out.print(i + " ");:
// This prints the current value of i followed by a space, without a newline character.
// This creates a space-separated list of numbers that are divisible by 10.
//After the for loop completes, the program prints the total count of numbers divisible by 10 with the line:
// System.out.println("total numbers=" + count);. This displays the total count to the console.
//
//In summary, this program reads two integers from the user, x and y, and then iterates through all integers between x and y (inclusive).
// It checks each integer to see if it's divisible by 10 and prints those numbers along with a count of how many were found.