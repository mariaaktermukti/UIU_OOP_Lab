class TestCalc
{
    public static void main(String[] args)
    {
        Calculator c1 = new Calculator(3, 2);
        System.out.println(c1.getFactorial());
        System.out.println(c1.getFactorial(4));
        System.out.println(c1.pow());
        System.out.println(c1.pow(4, 2));
        System.out.println(c1.multiply());
        System.out.println(c1.multiply(5, 6));
    }
}
