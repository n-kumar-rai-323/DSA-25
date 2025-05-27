
public class Product {
    public static int calculateProduct (int a, int b){
        int product = a * b;
        return product;
    }
    public static void main(String[] args) {
        int a =3;
        int b =4;
        int prod = calculateProduct(a, b);
        System.out.println(prod);
        System.out.println(a);
        System.out.println(b);
    }
}
