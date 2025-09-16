package pattern;
import java.util.*;

public class PyramidNumbers {
    public static void main(String[] args){
        Scanner kp=new Scanner(System.in);
        System.out.print("enter the value: ");
        int n= kp.nextInt();

        int i,j;
        for (i=1;i<=n;i++){
            //spaces
            int space =n-i;
            for(j=1;j<=space;j++){
                System.out.print(" ");
            }
            //printing the row no in the column form
            for (j=1;j<=i;j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
