public class MyBooking
{
    public static void main(String[] args)
    {
        Airplane plane = new Airplane("boeing747", 2012, 30);

        plane.setUnit_cost(12000);

        plane.Booking(5, 5);
    }
}
