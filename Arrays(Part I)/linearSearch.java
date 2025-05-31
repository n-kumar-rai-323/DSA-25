

public class linearSearch {
    public static int findKey(int number[], int key){
        for(int i=0; i<number.length; i++){
            if(number[i]==key){
                return i;
            }
        }
        return -1;
    }
public static void main(String[] args) {
    int number[]={22,33,44,656,1,2,4,6,8,7};
    int key = 4;
    int index = findKey(number, key);

    if(index ==-1){
        System.out.println("Key Not Found");
    }else{
        System.out.println("Key is " + index);
    }
}    
}
