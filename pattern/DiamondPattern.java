package pattern;
import java.util.*;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner kp = new Scanner(System.in);
        System.out.print("enter the value: ");
        int n = kp.nextInt();

        int i, j;
//upper half
        for (i = 1; i <=n; i++) {
            //spaces
            int spaces = n - i;
            for (j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            //stars
            int stars = 2 * i - 1;
            for (j =1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

//lower half
        for(i=n; i >= 1; i--){
            //spaces
            int spaces = n-i;
            for (j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            //stars
            int stars = 2 * i - 1;// there is differnce between 2(i-1) and 2*i-1 according to bodmas bracket solve first
            for (j = 1; j <= stars; j++) {// it gives 0 and in first doesn't 1 star print no start and in the result it will start by 2
                System.out.print("*");

            }

            System.out.println();

        }

    }
}
