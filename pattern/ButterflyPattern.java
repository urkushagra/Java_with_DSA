package pattern;
import java.util.*;

public class ButterflyPattern {
    public static void main(String[] args){
        Scanner kp =new Scanner(System.in);
        System.out.print("enter the value: " );
        int k = kp.nextInt();


        int i,j;
        for (i=1;i<=k;i++){//outer loops
            //upper half
            for(j=1;j<=i;j++){     // first part of triangle upper
                System.out.print("*");
            }
            int space=2*(k-i);
            for (j=1;j<=space;j++){ //spaces between the stars
                System.out.print(" ");
            }
            for(j=1;j<=i;j++){       //second part of triangle upper
                System.out.print("*");
            }
            System.out.println();
        }
        //lower half
        for (i=k;i>=1;i--){//outer loops

            for(j=1;j<=i;j++){     // first part of triangle lower
                System.out.print("*");
            }
            int space=2*(k-i);
            for (j=1;j<=space;j++){ //spaces between the stars
                System.out.print(" ");
            }
            for(j=1;j<=i;j++){       //second part of triangle lower
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
