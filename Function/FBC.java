
public class FBC {
    public static int binomialCoefficient(int n){
        int f =1;
        for(int i=1; i<=n; i++){
            f =f *i;
        }
        return f;
    }

    public static int secondFunction(int n, int r){
        int binomialN = binomialCoefficient(n);
        int binomialR = binomialCoefficient(r);
        int binomialNR =binomialCoefficient(n-r);
       int binCoeff = binomialN /(binomialR * binomialNR);
       return binCoeff;
    }
public static void main(String[] args) {
    System.out.println(secondFunction(5,2));
    
}
    
}