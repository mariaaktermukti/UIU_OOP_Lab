public class Airplane {
    public String model;
    public int year;
    private int seatingCapacity;
    private double unit_cost;
    private int[] availableSeats;

    public Airplane(String model, int year, int seatingCapacity, double unit_cost)
    {
        this.model = model;
        this.year = year;
        this.seatingCapacity = seatingCapacity;
        this.unit_cost = unit_cost;
        this.availableSeats = new int[seatingCapacity];
        // 0 = available, 1 = booked (initially all are available)
        for (int i = 0; i < seatingCapacity; i++)
        {
            availableSeats[i] = 0;
        }
    }

    // Constructor to initialize only model, year, and seatingCapacity
    public Airplane(String model, int year, int seatingCapacity)
    {
        this(model, year, seatingCapacity, 0.0);
    }

    // Getter for seatingCapacity
    public int getSeatingCapacity()
    {
        return seatingCapacity;
    }

    // Getter for unit_cost
    public double getUnit_cost()
    {
        return unit_cost;
    }

    // Setter for unit_cost
    public void setUnit_cost(double unit_cost)
    {
        this.unit_cost = unit_cost;
    }

    // Booking method
    public void Booking(int n, int luggage)
    {
        boolean found = false;
        int startIndex = -1;

        for (int i = 0; i <= seatingCapacity - n; i++)
        {
            boolean available = true;
            for (int j = i; j < i + n; j++)
            {
                if (availableSeats[j] == 1)
                {
                    available = false;
                    break;
                }
            }
            if (available)
            {
                startIndex = i;
                found = true;
                break;
            }
        }

        if (found)
        {
            for (int i = startIndex; i < startIndex + n; i++)
            {
                availableSeats[i] = 1; // Mark as booked
            }

            double totalCost = unit_cost * n;
            if (luggage > 3)
            {
                totalCost += (luggage - 3) * 600;
            }

            System.out.println("Seats booked successfully.");
            System.out.println("Total cost: " + totalCost + " Taka");
        }
        else
        {
            System.out.println("Seats are not available.");
        }
    }
}
