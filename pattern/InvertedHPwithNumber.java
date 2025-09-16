package pattern;

import java.util.Scanner;

public class InvertedHPwithNumber {
    public static void main(String[] args) {
        Scanner up = new Scanner(System.in);
        System.out.print("enter the value: ");
        int n = up.nextInt();

        int i, j;

        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i-n+1; j++) { //i-n+1 ##XFactor
                System.out.print(j + " ");

            }
            System.out.println();
        }
    }
}
