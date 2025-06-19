import java.io.*;

public class IDChecker {
    public static void main(String[] args) {
        File idFile = new File("id.txt");
        if (!idFile.exists())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(idFile))) {
                writer.write("011001212\n011002213\n011003214\n011004215\n011005216\n");
                System.out.println("id.txt created with sample data.");
            } catch (IOException e) {
                System.out.println("Failed to create id.txt: " + e.getMessage());
                return;
            }
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader("id.txt"));
                BufferedWriter evenWriter = new BufferedWriter(new FileWriter("even.txt"));
                BufferedWriter oddWriter = new BufferedWriter(new FileWriter("odd.txt"))
        ) {
            String id;
            while ((id = reader.readLine()) != null)
            {
                id = id.trim();
                if (!id.isEmpty())
                {
                    int lastDigit = Character.getNumericValue(id.charAt(id.length() - 1));
                    if (lastDigit % 2 == 0)
                    {
                        evenWriter.write(id + "\n");
                    }
                    else
                    {
                        oddWriter.write(id + "\n");
                    }
                }
            }
            System.out.println("ID Checked successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
