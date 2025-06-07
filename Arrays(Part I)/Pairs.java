public class Pairs {
    public static void printPairs(int number[]) {
        int totalPair = 0;
        for (int i = 0; i < number.length; i++) {
            int curr = number[i];
    
            for (int j = i + 1; j < number.length; j++) {
                System.out.print(" (" + curr + "," + number[j]+")");
                totalPair ++;
            }
            System.out.println();
        }
        System.out.println("total pairs = " + totalPair);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        printPairs(numbers);
    }
}
