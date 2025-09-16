package pattern;
import java.util.*;

public class InvertedHalfPyramid {
    public static void main(String[] args){
        Scanner ihp =new Scanner(System.in);
        System.out.print("enter the value: ");
        int n= ihp.nextInt();

        int i,j;

        for(i=n;i>=1;i--){
            for(j=1;j<=i;j++){
                System.out.print("*");

            }
            System.out.println();
        }
    }
}