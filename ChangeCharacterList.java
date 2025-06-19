import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeCharacterList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        sc.close();

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < input.length(); i++)
        {
            chars.add(input.charAt(i));
        }

        if (chars.size() > 2)
        {
            chars.set(2, 'z');
        }
        System.out.println("Modified character list: " + chars);
    }
}
