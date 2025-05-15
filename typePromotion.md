Type promotion in Java, also known as implicit type conversion or widening, is the automatic conversion of a smaller data type to a larger data type during the evaluation of an expression. This process is handled by the Java compiler to prevent data loss and ensure that operations are performed correctly. 
Rules of Type Promotion:
byte, short, and char are promoted to int:
When these data types are used in an expression, they are automatically converted to int before the operation is performed.
If one operand is long, the whole expression is promoted to long:
If one of the operands in an expression is of type long, the other operand will be converted to long, and the result will also be long. 
If one operand is float, the whole expression is promoted to float:
If one of the operands in an expression is of type float, the other operand will be converted to float, and the result will also be float. 
If any operand is double, the result is double:
If one of the operands in an expression is of type double, the other operand will be converted to double, and the result will also be double.
Example:
Java

public class TypePromotion {
    public static void main(String[] args) {
        byte b = 10;
        short s = 20;
        char c = 'a';
        int i = 30;
        long l = 1000L;
        float f = 20.5f;
        double d = 30.7;

        // byte, short, and char are promoted to int
        int result1 = b + s; // result1 is int (30)
        int result2 = c + i; // result2 is int (127)

        // If one operand is long, the whole expression is promoted to long
        long result3 = i + l; // result3 is long (1030)

        // If one operand is float, the whole expression is promoted to float
        float result4 = l + f; // result4 is float (1020.5)

        // If any operand is double, the result is double
        double result5 = f + d; // result5 is double (51.2)
    }
}
In this example, the Java compiler automatically promotes the smaller data types to larger data types to ensure that the operations are performed correctly and without data loss.