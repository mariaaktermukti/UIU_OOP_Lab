import java.util.Scanner;

//This Java program is designed to find the maximum value within an array of integers.

public class MaxValueofArray {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");

        int size=sc.nextInt();
        //This line reads an integer entered by the user, which represents the size (length) of the array, and stores it in the variable size.

        int[] arr=new int[size];
        //This line declares an integer array named arr with a length equal to the value entered by the user (stored in size).

        for (int i = 0; i < size; i++) {
            System.out.println("Enter "+i+" th number");
            arr[i]=sc.nextInt();
        }

        //This is a for loop that iterates size times. Inside the loop:
        // arr[i] = sc.nextInt();: This line reads an integer entered by the user and assigns it to the i-th element of the array arr.
        // The loop allows the user to input values for each element of the array.

        int max=arr[0];
        //After the user has entered all the values for the array, the program initializes a variable max with the value of
        // the first element of the array. This assumes that the first element is the maximum initially.


        //The program then enters another for loop to compare each element of the array with the current maximum value:
        //This loop iterates through all the elements of the array.
        //if (arr[i] > max) { ... }: This condition checks if the current element arr[i] is greater than the current maximum max.
        // If it is, it updates max to be equal to the new maximum value.

        //using normal for loop to find maximum value

//        for (int i = 0; i < size; i++) {
//            if (arr[i]>max) {
//                max=arr[i];
//            }
//        }

//         Use an enhanced for loop to find the maximum value
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }


// What happens if we write enhance for loop something like this:
//        for (int i : arr) {
//            if (arr[i] > max) {
//                max = arr[i];
//            }
//        }

// We will encounter error java.lang.ArrayIndexOutOfBoundsException,  because you're trying to access an array element
// using an index that is out of bounds. Here, i represents the actual values in the array, not the indices.
// So, when you try to access arr[i], you're effectively attempting to access an array element using the element itself as an index,
// which can lead to an ArrayIndexOutOfBoundsException.

        System.out.println("maximum value= "+max);
    }
}