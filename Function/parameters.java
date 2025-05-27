
public class parameters {
    public static int calculateSum(int a, int b) // formal parameter
    {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        // actual parameter
        calculateSum(4, 5);
    }
}
