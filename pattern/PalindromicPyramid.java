package pattern;
import java.util.*;

public class PalindromicPyramid {
    public static void main(String[] args){
        Scanner kp =new Scanner(System.in);
        System.out.print("enter the value: ");
        int n= kp.nextInt();

        int i,j;
        for (i=1; i<=n; i++){
            //spaces
            int spaces=n-i;
            for (j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            //first half of palindrome
            for (j=i; j>=1; j--){
                System.out.print(j);
            }
            //second half of palindrome
            for(j=2; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
