package pattern;
import java.util.*;

public class HollowRectangle {
    public static void main(String[] args){
        Scanner hr =new Scanner(System.in);
        System.out.print("how much row you want: ");
        int row = hr.nextInt();
        System.out.print("how much column you want: ");
        int column= hr.nextInt();
        int i,j;

        for(i=1;i<=row;i++){  // outer loop
            for(j=1;j<=column;j++){  // inner loop
                if(i==1 || j==1 || i==row || j== column){
                    System.out.print("#");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
