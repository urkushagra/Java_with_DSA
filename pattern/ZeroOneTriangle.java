package pattern;
import java.util.*;

public class ZeroOneTriangle {
    public static void main(String[] args){
        Scanner kp=new Scanner(System.in);
        System.out.print("enter the value: ");
        int n =kp.nextInt();


        int i,j;

        for (i=1;i<=n;i++){
            for (j=1;j<=i;j++){
                int sum= i+j;
                if(sum%2==0){
                    System.out.print("1" + " "); // if sum of the coordinates are even by forming matrix
                }
                else {
                    System.out.print("0" + " "); // if the sum of the coordinates are odd by forming matrix
                }
            }
            System.out.println();
        }
    }
}
