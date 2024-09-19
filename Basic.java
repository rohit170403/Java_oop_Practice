package practice;

public class Basic {
public static void main(String[] args) {
int a = 2, b = 3;
float f = 1.3f;
long l = 123456000;
boolean x = true;
System.out.println("Value of " + a + " + " + b + " is " + (a + b));
System.out.println(f);
System.out.println(l);
System.out.println(x);
System.out.println();
int num = 7;
if (num % 2 == 0) {
System.out.println(num + " is even.");
} else {
System.out.println(num + " is odd.");
}
System.out.println();
int num1 = 2, num2 = 3;
System.out.println("addition : " + (num1 + num2));
System.out.println("Subtraction : " + (num1 - num2));
System.out.println("division : " + (num1 / num2));
System.out.println("multiplication : " + (num1 * 
 num2));
System.out.println();
Square(5, 5);
}
public static void Square(int rows, int columns) {
for (int i = 0; i < rows; i++) {
for (int j = 0; j < columns; j++) {
if (i == 0 || j == 0 || j == columns - 1 || 
i == columns - 1 || i == columns / 2 || j 
== columns / 2)
System.out.print("* ");
else
System.out.print(" ");
}
System.out.println();
}
}
}

