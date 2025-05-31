
public class Str {
    public static int strKey(String str[], String key) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str[] = { "Nishan", "Alisha", "Nikita", "Nipla" };
        String key = "Nishan";

        int index = strKey(str, key);

        if (index != -1) {
            System.out.println("Key '" + key + "' found at index: " + index);
        } else {
            System.out.println("Key '" + key + "' not found in the array.");
        }
    }
}
