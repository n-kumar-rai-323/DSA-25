import java.util.Scanner;

public class CreatingArray {
    public static void updateMark(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        // Array Creation
        // int marks[] = new int [5];
        // int number[]= {1,2,3,4,5,6};
        // String fruits[]={"Apple", "Mango", "Orange"};

        // Arrays - Input, Output and Update

        // int marks[] = new int[50];
        // Scanner sc = new Scanner(System.in);
        // marks[0]=sc.nextInt();
        // marks[1] = 40;
        // System.out.println(marks[0]);
        // System.out.println(marks[1]);
        // System.out.println( "Array length is : " + marks.length);

        int marks[] = { 97, 98, 99 };
         updateMark(marks);


        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
          updateMark(marks);
    }
}
