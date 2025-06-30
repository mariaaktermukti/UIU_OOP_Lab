import java.io.*;

public class CalculateProfit {
    static class InvalidPriceException extends Exception
    {
        InvalidPriceException(String msg)
        {
            super(msg);
        }
    }
    static class TotalUnitSoldMinimumBoundException extends Exception
    {
        TotalUnitSoldMinimumBoundException(String msg)
        {
            super(msg);
        }
    }
    static class TotalUnitSoldMaximumBoundException extends Exception
    {
        TotalUnitSoldMaximumBoundException(String msg)
        {
            super(msg);
        }
    }

    public static void main(String[] args)
    {
        String inputName  = "AnnualSell.txt";
        String outputName = "Profit.txt";

        File inFile = new File(inputName);
        if (!inFile.exists())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(inFile))) {
                writer.write(
                        "Item UnitCost UnitSellingPrice TotalUnitSold\n" +
                                "Pen 8 10 500\n" +
                                "Paper 8.5 10 450\n" +
                                "File 50 55 100\n" +
                                "Java Book 250 -260 75\n" +
                                "Mouse 300 298 65\n" +
                                "Ruler 5.5 6 600\n" +
                                "Pencil 7 7.5 45\n"
                );
                System.out.println("Created sample " + inputName);
            } catch (IOException e) {
                System.err.println("Failed to create sample file: " + e.getMessage());
                return;
            }
        }

        double totalProfit = 0;
        String maxItem = "";
        double maxProfit = Double.NEGATIVE_INFINITY;

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputName));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputName))
        ) {
            bw.write("Item\tProfit");
            bw.newLine();

            br.readLine();

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.trim().split("\\s+");
                if (parts.length != 4) continue;

                String item = parts[0];
                double cost = Double.parseDouble(parts[1]);
                double price = Double.parseDouble(parts[2]);
                int units = Integer.parseInt(parts[3]);

                if (cost < 0 || price < 0)
                {
                    throw new InvalidPriceException(
                            "Negative cost/price for " + item + ": cost=" + cost + ", price=" + price
                    );
                }
                if (units < 0)
                {
                    throw new TotalUnitSoldMinimumBoundException(
                            "Units sold < 0 for " + item + ": " + units
                    );
                }
                if (units > 1000)
                {
                    throw new TotalUnitSoldMaximumBoundException(
                            "Units sold > 1000 for " + item + ": " + units
                    );
                }

                double profit = (price - cost) * units;
                totalProfit += profit;

                if (profit > maxProfit)
                {
                    maxProfit = profit;
                    maxItem = item;
                }

                bw.write(item + "\t" + String.format("%.2f", profit));
                bw.newLine();
            }

            bw.newLine();
            bw.write("Total Profit:\t" + String.format("%.2f", totalProfit));
            bw.newLine();
            bw.write("Max Profit Item:\t" + maxItem);

            System.out.println("Calculation okay! See calculation in " + outputName);

        } catch (FileNotFoundException fnfe) {
            System.err.println("Cannot find file: " + inputName);
        } catch (InvalidPriceException |
                 TotalUnitSoldMinimumBoundException |
                 TotalUnitSoldMaximumBoundException e) {
            System.err.println("Data error: " + e.getMessage());
        } catch (IOException ioe) {
            System.err.println("I/O error: " + ioe.getMessage());
        }
    }
}
