import java.util.Scanner;

public class caalculator {
    public static void main(String[] args) {
        int num1,num2;
        char operator;
        double ansr=0.0;

        Scanner scanChar = new Scanner(System.in);

        System.out.print("enter the first nmbr");
        num1 = scanChar.nextInt();
        System.out.println("enter second number");
        num2 = scanChar.nextInt();
        System.out.println("enter the operator");
        operator = scanChar.next().charAt(0);

        switch (operator){
            case '*' : ansr = num1 * num2;
        }
        System.out.println(num1+""+operator+""+num2+"="+ansr);
    }
}
