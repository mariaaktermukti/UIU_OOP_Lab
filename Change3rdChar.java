import java.util.ArrayList;
import java.util.Scanner;

public class Change3rdChar
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        ArrayList<Character> charList = new ArrayList<>();
        for (char ch : input.toCharArray())
        {
            charList.add(ch);
        }

        if (charList.size() > 2)
        {
            charList.set(2, 'z');
        }

        for (char c : charList)
        {
            System.out.print(c);
        }

        sc.close();
    }
}
