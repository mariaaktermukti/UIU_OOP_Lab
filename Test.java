public class Test
{

    public static void main(String[] args)
    {
        Icecream I1 = new Icecream("Chocolate", "Polar", 290.0);

        Icecream I2 = new Icecream("Chocolate", "Polar", 290.0);
        System.out.println(I1.equals(I2));
    }
}