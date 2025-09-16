package pattern;
import java.util.*;

public class Rhombous {
    public static void main(String[] args){
        Scanner kp =new Scanner(System.in);
        System.out.print("Enter the value: ");
        int n = kp.nextInt();

        int i,j;

        for(i=1;i<=n;i++){
            //spaces
            int space =n-i;
            for(j=1;j<=space; j++){
                System.out.print(" ");
            }
            //basic working as rectangle
            for (j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}// if we don't understand the pattern problem we should use matrix to find th relation between cordinates and the pattern
//use conditional statement in the loops to solve the problems 