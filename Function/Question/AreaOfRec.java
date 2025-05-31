public class AreaOfRec {
    public static double calRectArea(double length, double width){
       if(length < 0 || width < 0){
        System.out.println("Warning: Length and width cannot be negative. Returing 0.0");
        return 0.0; 
       }
    double area = length * width;
    return area;
    }
    public static void main(String[] args) {
        System.out.println("----Rectangle Area Calculator -----");
        double length = 10.0;
        double width=5.0;
        double area = calRectArea(length, width);
        System.out.println("Rectangle (Length: " +  length + ", Width " + width + ") Area: " + area );
    }
}
