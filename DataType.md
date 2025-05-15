Data types in Java specify the size and type of values that can be stored in a variable. Java has two main categories of data types: primitive and non-primitive. 
Primitive Data Types
These are predefined data types built into the Java language. There are eight primitive data types:
byte: 8-bit integer, range from -128 to 127.
short: 16-bit integer, range from -32,768 to 32,767.
int: 32-bit integer, range from -2,147,483,648 to 2,147,483,647.
long: 64-bit integer, range from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807.
float: 32-bit floating-point number.
double: 64-bit floating-point number.
boolean: Represents true or false values.
char: 16-bit Unicode character.
Java

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        byte byteVar = 100;
        short shortVar = 20000;
        int intVar = 1500000;
        long longVar = 9000000000L;
        float floatVar = 3.14f;
        double doubleVar = 3.14159265359;
        boolean booleanVar = true;
        char charVar = 'A';

        System.out.println("Byte: " + byteVar);
        System.out.println("Short: " + shortVar);
        System.println("Int: " + intVar);
        System.out.println("Long: " + longVar);
        System.out.println("Float: " + floatVar);
        System.out.println("Double: " + doubleVar);
        System.out.println("Boolean: " + booleanVar);
        System.out.println("Char: " + charVar);
    }
}
Non-Primitive Data Types
These are reference types created by the programmer and are not predefined by Java (except for String). They include: 
Classes: Blueprints for objects, defining their attributes and behaviors.
Interfaces: Contracts that define a set of methods that a class must implement.
Arrays: Collections of elements of the same data type.
Strings: Sequences of characters.
Java

public class NonPrimitiveDataTypes {
    public static void main(String[] args) {
        String strVar = "Hello, Java!";
        int[] intArray = {1, 2, 3, 4, 5};

        System.out.println("String: " + strVar);
        System.out.print("Array: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}