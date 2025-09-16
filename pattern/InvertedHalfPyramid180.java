package pattern;
import  java.util.*;

public class InvertedHalfPyramid180 {
    public static void main(String[] args){
        Scanner ihp = new Scanner(System.in);
        System.out.print("enter the value : ");
        int n = ihp.nextInt();

        int i,j;

        for (i=1;i<=n;i++) {   // outer loop is used for printing rows
                               //we use two different inner loops separately
            for (j = 1; j <= n - i; j++) {   // used for printing SPACE ##n-i relation
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {      // used for printing STAR
                System.out.print("*");
            }
            System.out.println();
        }
    }
}