public class Calculator
{
    private int a;
    private int b;

    // Constructor
    public Calculator(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    // Factorial method with no argument
    public int getFactorial()
    {
        System.out.println("Factorial method with no arg");
        return factorial(a); // Using 'a' from the object
    }

    // Factorial method with 1 argument
    public int getFactorial(int num)
    {
        System.out.println("Factorial method with 1 arg");
        return factorial(num);
    }

    // Helper method to calculate factorial
    private int factorial(int n)
    {
        int result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
        return result;
    }

    // Power method with no argument: a^b
    public int pow()
    {
        System.out.println("power method with no arg");
        return (int) Math.pow(a, b);
    }

    // Power method with 2 arguments
    public int pow(int base, int exp)
    {
        System.out.println("pow method for 2 arg");
        return (int) Math.pow(base, exp);
    }

    // Multiply method with no arguments
    public int multiply()
    {
        System.out.println("multiple method with no arg");
        return a * b;
    }

    // Multiply method with 2 arguments
    public int multiply(int x, int y)
    {
        System.out.println("multiple method with 2 arg");
        return x * y;
    }
}
