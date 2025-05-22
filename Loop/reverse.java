package Loop;

public class reverse {
    public static void main(String[] args) {
        int date = 1998;
        while(date >0){
            int lastDigit = date %10;
            System.out.print(lastDigit + " ");
            System.out.println(date);
            date= date/10;
        }
        System.out.println();
    }
}
