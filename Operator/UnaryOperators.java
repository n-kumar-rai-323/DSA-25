public class UnaryOperators {
    public static void main(String[] args) {
        System.out.println("Unary Operators");

        // Pre Increment                Post Increment 
        // ++a                          a++

        int a = 10;
        int b = ++a;
        System.out.println(a);
        System.out.println(b);

        int c = 10;
        int d = c++;
        System.out.println(c);
        System.out.println(d);
    }
}
